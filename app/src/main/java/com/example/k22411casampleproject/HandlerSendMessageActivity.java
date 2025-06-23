package com.example.k22411casampleproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class HandlerSendMessageActivity extends AppCompatActivity {

    EditText edtNumber;
    Button btnDraw;
    TextView txtPercent;
    ProgressBar progressBarPercent;
    LinearLayout linearLayoutButton;

    int numberOfButton = 0;
    Handler handler; // Đổi từ khai báo trong hàm -> khai báo toàn cục

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_handler_send_message);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnDraw), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addViews() {
        edtNumber = findViewById(R.id.edtNumber);
        btnDraw = findViewById(R.id.btnDraw);
        txtPercent = findViewById(R.id.txtPercent);
        progressBarPercent = findViewById(R.id.progressBarPercent);
        linearLayoutButton = findViewById(R.id.linearLayoutButton);
    }

    private void addEvents() {
        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDrawButtonThreating();
            }
        });
    }

    private void processDrawButtonThreating() {
        numberOfButton = Integer.parseInt(edtNumber.getText().toString());
        btnDraw.setEnabled(false);
        linearLayoutButton.removeAllViews();
        createHandlerObject();
        runThread();
    }

    private void runThread() {
        Random random = new Random();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= numberOfButton; i++) {
                    Message message = handler.obtainMessage();
                    message.arg1 = i * 100 / numberOfButton; //Percent
                    message.obj = random.nextInt(100);
                    handler.sendMessage(message);
                    SystemClock.sleep(100);
                }
            }
        });
        thread.start();
    }

    private void createHandlerObject() {
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                int percent = message.arg1;
                if (percent == 100) {
                    Toast.makeText(HandlerSendMessageActivity.this, "DONE",
                            Toast.LENGTH_LONG).show();
                    btnDraw.setEnabled(true);
                } else {
                    int value = (int) message.obj;
                    Button btn = new Button(HandlerSendMessageActivity.this);
                    btn.setText(value + "");
                    btn.setHeight(50);
                    btn.setHeight(300);
                    linearLayoutButton.addView(btn);
                    txtPercent.setText(percent + " %");
                    progressBarPercent.setProgress(percent);
                }
                return true;
            }
        });
    }
}
