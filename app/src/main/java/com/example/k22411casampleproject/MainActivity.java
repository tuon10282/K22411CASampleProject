package com.example.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView imgEmployee;
    TextView txtEmployee;
    ImageView imgCustomer;
    TextView txtCustomer;
    ImageView imgCategory;
    TextView txtCategory;
    ImageView imgProduct;
    TextView txtProduct;
    ImageView imgAdvancedProduct;
    TextView txtAdvancedProduct;
    TextView txtPaymentMethod;
    ImageView imgPaymentMethod;

    TextView txtOrders;
    ImageView imgOrders;
    TextView txtContact;
    ImageView imgContact;
    TextView txtMultiThreading;
    ImageView imgMultiThreading;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnDraw), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void addEvents() {
        // Employee
        imgEmployee.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Đã bấm ảnh nhân viên", Toast.LENGTH_SHORT).show();
            openEmployeeManagementActivity();
        });

        txtEmployee.setOnClickListener(v -> {
            openEmployeeManagementActivity();
        });

        // Customer
        imgCustomer.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Đã bấm ảnh khách hàng", Toast.LENGTH_SHORT).show();
            openCustomerManagementActivity();
        });

        txtCustomer.setOnClickListener(v -> {
            openCustomerManagementActivity();
        });
        // Customer
        imgCategory.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Đã bấm ảnh khách hàng", Toast.LENGTH_SHORT).show();
            openCategoryManagementActivity();
        });

        txtCategory.setOnClickListener(v -> {
            openCategoryManagementActivity();
        });
        // Customer
        imgProduct.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Đã bấm ảnh khách hàng", Toast.LENGTH_SHORT).show();
            openProductManagementActivity();
        });

        txtProduct.setOnClickListener(v -> {
            openProductManagementActivity();;
        });
        // Advanced Product
        imgAdvancedProduct.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Đã bấm ảnh khách hàng", Toast.LENGTH_SHORT).show();
            openAdvancedProductManagementActivity();
        });

        txtAdvancedProduct.setOnClickListener(v -> {
            openAdvancedProductManagementActivity();;
        });
        //Payment Method
        imgPaymentMethod.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Đã bấm ảnh khách hàng", Toast.LENGTH_SHORT).show();
            openPaymentMethod();
        });

        txtPaymentMethod.setOnClickListener(v -> {
            openPaymentMethod();
        });
        //Payment Method
        imgOrders.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Đã bấm ảnh khách hàng", Toast.LENGTH_SHORT).show();
            openOrderViewerActivity();
        });

        txtOrders.setOnClickListener(v -> {
            openOrderViewerActivity();
        });
        imgContact.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Đã bấm ảnh khách hàng", Toast.LENGTH_SHORT).show();
            openContactActivity();
        });

        txtContact.setOnClickListener(v -> {
            openContactActivity();
        });
        imgMultiThreading.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Đã bấm ảnh khách hàng", Toast.LENGTH_SHORT).show();
            openMultiThreadingActivity();
        });

        txtMultiThreading.setOnClickListener(v -> {
            openMultiThreadingActivity();
        });




    }



    private void addViews() {
        imgEmployee=findViewById(R.id.imgEmployee);
        txtEmployee=findViewById(R.id.txtEmployee);
        imgCustomer=findViewById(R.id.imgCustomer);
        txtCustomer=findViewById(R.id.txtCustomer);
        imgCategory=findViewById(R.id.imgCategory);
        txtCategory=findViewById(R.id.txtCategory);
        imgProduct=findViewById(R.id.imgProduct);
        txtProduct=findViewById(R.id.txtProduct);
        imgAdvancedProduct=findViewById(R.id.imgAdvancedProduct);
        txtAdvancedProduct=findViewById(R.id.txtAdvancedProduct);
        imgPaymentMethod=findViewById(R.id.imgPaymentMethod);
        txtPaymentMethod=findViewById(R.id.txtPaymentMethod);
        imgOrders=findViewById(R.id.imgOrders);
        txtOrders=findViewById(R.id.txtOrders);
        txtContact=findViewById(R.id.txtContact);
        imgContact=findViewById(R.id.imgContact);
        txtMultiThreading=findViewById(R.id.txtMultiThreading);
        imgMultiThreading=findViewById(R.id.imgMultiThreading);


    }
    private void openEmployeeManagementActivity()
    {
        Intent intent = new Intent(MainActivity.this, EmployeeManagementActivity.class);
        startActivity(intent);
    }
    private void openCustomerManagementActivity()
    {
        Intent intent = new Intent(MainActivity.this, CustomerManagementActivity.class);
        startActivity(intent);
    }
    private void openCategoryManagementActivity()
    {
        Intent intent = new Intent(MainActivity.this, CategoryManagementActivity.class);
        startActivity(intent);
    }
    private void openProductManagementActivity()
    {
        Intent intent = new Intent(MainActivity.this, ProductManagementActivity.class);
        startActivity(intent);
    }
    private void openAdvancedProductManagementActivity()
    {
        Intent intent = new Intent(MainActivity.this, AdvancedProductManagementActivity.class);
        startActivity(intent);
    }

    private void openPaymentMethod() {
        Intent intent = new Intent(MainActivity.this, PaymentMethodActivity.class);
        startActivity(intent);

    }
    private void openOrderViewerActivity() {
        Intent intent = new Intent(MainActivity.this, OrdersViewerActivity.
                class);
        startActivity(intent);

    }
    private void openContactActivity() {
        Intent intent = new Intent(MainActivity.this, TelephonyActivity.
                class);
        startActivity(intent);

    }
    private void openMultiThreadingActivity() {
        Intent intent = new Intent(MainActivity.this, MultiThreadingCategoriesActivity.
                class);
        startActivity(intent);

    }






}