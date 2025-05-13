package com.example.k22411casampleproject;
import com.example.utils.HealthCare;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.utils.BMIStatus;

public class EmployeeHealthcareActivity extends AppCompatActivity {

    EditText edtHeight;
    EditText edtWeight;

    Button btn_cal;
    Button btn_clear;
    Button btn_close;

    TextView txtResults;

    View.OnClickListener myClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_healthcare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        myClick=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xử lí sự kiện chi tiết trong này
                if(v.equals(btn_cal))
                {
                    //nút Calculate được dùng sự kiện
                    double h=Double.parseDouble(edtHeight.getText().toString());
                    double w=Double.parseDouble(edtWeight.getText().toString());
                    BMIStatus bmiStatus= HealthCare.calculate_bmi(h,w);
                    txtResults.setText(bmiStatus.getBMI()+"=>"+bmiStatus.getDescription());
                }
                else if (v.equals(btn_clear))
                {
                    //nút CLear đang dùng sự kiện
                    edtHeight.setText("");
                    edtWeight.setText("");
                    txtResults.setText("");
                    edtHeight.requestFocus();

                }
                else if(v.equals(btn_close))
                {
                    //nút Cancel đang dùng sự kiện
                    finish();
                }
            }
        };
        //gán chia sẻ chung sự kiện:
        btn_cal.setOnClickListener(myClick);
        btn_clear.setOnClickListener(myClick);
        btn_close.setOnClickListener(myClick);
    }

    private void addViews() {
        txtResults=findViewById(R.id.txtResults);
        edtHeight=findViewById(R.id.edtHeight);
        edtWeight=findViewById(R.id.edtWeight);
        btn_cal=findViewById(R.id.btn_cal);
        btn_clear=findViewById(R.id.btn_clear);
        btn_close=findViewById(R.id.btn_close);

    }
}