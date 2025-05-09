package com.example.k22411casampleproject;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
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

public class LoginActivity extends AppCompatActivity {

    EditText edtUserName;
    EditText edtPassword;
    CheckBox chkSaveLogin;
    private int backPressCount = 0; // Counter for back button presses
    private static final long BACK_PRESS_INTERVAL = 2000; // 2 seconds interval
    private long lastBackPressTime = 0; // Timestamp of last back press





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        addViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        edtUserName=findViewById(R.id.edtUserName);
        edtPassword=findViewById(R.id.edtPassword);
        chkSaveLogin=findViewById(R.id.chkSaveLoginInfo);


    }

    public void do_login(View view) {
        EmployeeConnector ec=new EmployeeConnector();

        String usr=edtUserName.getText().toString();
        String pwd=edtPassword.getText().toString();

        Employee e_login=ec.login(usr,pwd);
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

}