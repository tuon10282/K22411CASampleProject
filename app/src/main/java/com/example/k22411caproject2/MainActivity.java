package com.example.k22411caproject2;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText edtCoefficientA, edtCoefficientB;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load locale từ SharedPreferences (có thể là "en", "vi", "fr")
        setLocale(getSharedPreferences("app", MODE_PRIVATE).getString("lang", "en"));

        setContentView(R.layout.activity_main);
        addViews();
    }

    private void addViews() {
        edtCoefficientA = findViewById(R.id.edtCoefficientA);
        edtCoefficientB = findViewById(R.id.edtCoefficientB);
        txtResult = findViewById(R.id.txtResult);
    }

    // Hàm giải phương trình bậc 1
    public void do_solution(View view) {
        // Lấy giá trị từ các ô nhập
        double a = Double.parseDouble(edtCoefficientA.getText().toString());
        double b = Double.parseDouble(edtCoefficientB.getText().toString());

        // Giải phương trình
        if (a == 0) {
            if (b == 0) {
                txtResult.setText(getString(R.string.title_infinity));
            } else {
                txtResult.setText(getString(R.string.title_nosulution));
            }
        } else {
            double x = -b / a;
            txtResult.setText("x = " + x);
        }
    }

    // Hàm xóa dữ liệu và làm lại
    public void do_next(View view) {
        edtCoefficientA.setText("");
        edtCoefficientB.setText("");
        txtResult.setText("");
        edtCoefficientA.requestFocus();
    }

    // Hàm thoát ứng dụng
    public void do_exit(View view) {
        finish();
    }

    // Đổi ngôn ngữ sang tiếng Anh
    public void setEnglish(View view) {
        changeLanguage("en");
    }

    // Đổi ngôn ngữ sang tiếng Việt
    public void setVietnamese(View view) {
        changeLanguage("vi");
    }

    // Đổi ngôn ngữ sang tiếng Pháp
    public void setFrench(View view) {
        changeLanguage("fr");
    }
    public void setSpain(View view) {
        changeLanguage("es");
    }

    // Lưu ngôn ngữ vào SharedPreferences và reload lại activity
    private void changeLanguage(String langCode) {
        SharedPreferences.Editor editor = getSharedPreferences("app", MODE_PRIVATE).edit();
        editor.putString("lang", langCode);
        editor.apply();
        recreate(); // Tải lại activity để áp dụng ngôn ngữ mới
    }

    // Cập nhật ngôn ngữ dựa trên mã ngôn ngữ
    private void setLocale(String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
}
