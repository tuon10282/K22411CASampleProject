package com.example.k22411casampleproject;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.k22411casampleproject.connectors.EmployeeConnector;
import com.example.k22411casampleproject.models.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LoginActivity extends AppCompatActivity {

    EditText edtUserName;
    EditText edtPassword;
    CheckBox chkSaveLogin;
    Button btnLogin;

    private int backPressCount = 0; // Counter for back button presses
    private static final long BACK_PRESS_INTERVAL = 2000; // 2 seconds interval
    private long lastBackPressTime = 0; // Timestamp of last back press

    String DATABASE_NAME="SalesDatabase.db";
    private static final String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database=null;
    BroadcastReceiver networkReceiver=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        addViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnDraw), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        processCopy();
        setupBroadcasrReceiver();

    }

    private void setupBroadcasrReceiver() {
        networkReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo= connectivityManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected())
                {
                    btnLogin.setVisibility(View.VISIBLE);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Internet khong co", Toast.LENGTH_LONG).show();
                    btnLogin.setVisibility(View.INVISIBLE);
                }
            }
        };
    }

    private void addViews() {
        edtUserName=findViewById(R.id.edtUserName);
        edtPassword=findViewById(R.id.edtPassword);
        chkSaveLogin=findViewById(R.id.chkSaveLoginInfo);
        btnLogin=findViewById(R.id.btnLogin);

    }

    public void do_login(View view) {
        EmployeeConnector ec=new EmployeeConnector();

        String usr=edtUserName.getText().toString();
        String pwd=edtPassword.getText().toString();

        Employee e_login=ec.login(this,usr,pwd);
        if (e_login!=null) {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Login failed! check your account again", Toast.LENGTH_LONG).show();
        }
    }
    public void do_exit(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
        // Thiết lập tiêu đề
            Resources res=getResources();
            builder.setTitle(res.getText(R.string.title_confirm_exit_title));
            builder.setMessage(res.getText(R.string.title_confirm_exit_message));
            builder.setIcon(android.R.drawable.ic_dialog_alert);

            // Thiết lập tương tác người dùng
            builder.setPositiveButton(res.getText(R.string.title_confirm_exit_OK), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //finish()
                    System.exit(0);
                }
            });
            builder.setNegativeButton(res.getText(R.string.title_confirm_exit_cancle), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog= builder.create();
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
    }

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();

        // Reset counter if too much time has passed since last press
        if (currentTime - lastBackPressTime > BACK_PRESS_INTERVAL) {
            backPressCount = 0;
        }

        // Increment counter
        backPressCount++;
        lastBackPressTime = currentTime;

        // Show dialog only on exactly the third press
        if (backPressCount == 3) {
            do_exit(null); // Call your do_exit method to show the dialog
            backPressCount = 0; // Reset counter after showing dialog
        } else if (backPressCount < 3) {
            Toast.makeText(this, "Nhấn back " + (3 - backPressCount) + " lần nữa để thoát", Toast.LENGTH_SHORT).show();
        }
        // Do NOT call super.onBackPressed() to prevent premature exit
    }
    public void saveLoginInformation()
    {
        SharedPreferences preferences=getSharedPreferences("LOGIN_PREFERENCE",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        String usr=edtUserName.getText().toString();
        String pwd=edtPassword.getText().toString();
        boolean isSave=chkSaveLogin.isChecked();
        editor.putString("USER_NAME",usr);
        editor.putString("PASSWORD",pwd);
        editor.putBoolean("SAVED",isSave);
        editor.commit();

    }

    @Override
    protected void onPause() {
        super.onPause();
        saveLoginInformation();
        if(networkReceiver!=null)
        unregisterReceiver(networkReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreLoginInformation();

        IntentFilter filter= new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkReceiver, filter);
    }

    public void restoreLoginInformation()
    {
        SharedPreferences preferences=getSharedPreferences("LOGIN_PREFERENCE",MODE_PRIVATE);
        String usr=preferences.getString("USER_NAME"," ");
        String pwd=preferences.getString("PASSWORD"," ");
        boolean isSave=preferences.getBoolean("SAVED",false);
        if(isSave)
        {
            edtUserName.setText(usr);
            edtPassword.setText(pwd);
            chkSaveLogin.setChecked(isSave);
        }
    }
    private void processCopy() {
        File dbFile = getDatabasePath(DATABASE_NAME);

        Log.d("DB_DEBUG", "Database path: " + dbFile.getAbsolutePath());

        if (!dbFile.exists()) {
            try {
                Log.d("DB_DEBUG", "Database does not exist. Copying from assets...");
                CopyDataBaseFromAsset();
                Log.d("DB_DEBUG", "Database copied successfully.");
            } catch (Exception e) {
                Log.e("DB_DEBUG", "Error copying database: ", e);
            }
        } else {
            Log.d("DB_DEBUG", "Database already exists. Skipping copy.");
        }
    }
    private String getDatabasePath() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX+ DATABASE_NAME;
    }
    public void CopyDataBaseFromAsset()
    {
        try {
            InputStream myInput;

            myInput = getAssets().open(DATABASE_NAME);


            // Path to the just created empty db
            String outFileName = getDatabasePath();

            // if the path doesn't exist first, create it
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists())
                f.mkdir();

            // Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);

            // transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }

            // Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}