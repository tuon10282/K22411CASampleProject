package com.example.k22411casampleproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.adapters.TelephonyInforAdapter;
import com.example.k22411casampleproject.models.TelephonyInfor;

import java.util.Random;

public class HandlerPostMessageActivity extends AppCompatActivity {
    EditText edtNumberOfContact;
    Button btnCreateContact;
    TextView txtPercent;
    ProgressBar progressBarPercent;
    ListView lvContact;
    TelephonyInforAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_handler_post_message);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        btnCreateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processThread();
            }
        });
    }
    int numberOfContact=0;
    int numb = 0, percent, value;
    Handler handler = new Handler();
    TelephonyInfor ti_in_background=null;
    Runnable foregroundThread = new Runnable() {
        @Override
        public void run() {
            txtPercent.setText(percent + " %");
            progressBarPercent.setProgress(percent);
            //UPDATE UI …
            if (ti_in_background!=null) // cos dữ liệu từ tiến trình gửi về
            {
                adapter.add(ti_in_background);
            }
        }
    };


    private void processThread() {
        numberOfContact=Integer.parseInt(edtNumberOfContact.getText().toString());
        adapter.clear();
        txtPercent.setText("0%");
        progressBarPercent.setProgress(0);
        btnCreateContact.setEnabled(false);
        Random random = new Random();
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<=numberOfContact; i++){
                    percent =  i*100/numberOfContact; //Percent
                    value = random.nextInt(100);
                    handler.post(foregroundThread);
                    SystemClock.sleep(100);
                }
            }
        });
        backgroundThread.start();


    }

    private void addViews() {
        edtNumberOfContact=findViewById(R.id.edtNumberOfContact);
        btnCreateContact=findViewById(R.id.btnCreateContact);
        txtPercent=findViewById(R.id.txtPercent);
        progressBarPercent=findViewById(R.id.progressBarPercent);
        lvContact=findViewById(R.id.lvContact);
        adapter=new TelephonyInforAdapter(this,R.layout.item_telephonyinfor);
        lvContact.setAdapter(adapter);
    }
}