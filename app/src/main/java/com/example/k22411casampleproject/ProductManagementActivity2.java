package com.example.k22411casampleproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.k22411casampleproject.models.Category;
import com.example.k22411casampleproject.models.ListCategory;
import com.example.k22411casampleproject.models.Product;

public class ProductManagementActivity2 extends AppCompatActivity {

    Spinner spinnerCategory;
    ArrayAdapter<Category> adapterCategory;
    ListCategory ListCategory;

    ListView lvProducts;
    ArrayAdapter<Product> adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_management2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Category c = adapterCategory.getItem(position);
                displayProductByCategory(c);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void displayProductByCategory(Category c) {
        adapterProduct.clear();

        adapterProduct.addAll(c.getProducts());
    }

    private void addViews() {
        spinnerCategory = findViewById(R.id.spinnerCategory);
        adapterCategory = new ArrayAdapter<>(ProductManagementActivity2.this,
                android.R.layout.simple_spinner_item);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);

        lvProducts = findViewById(R.id.lvProduct);
        adapterProduct = new ArrayAdapter<>(ProductManagementActivity2.this,
                android.R.layout.simple_spinner_item);
        lvProducts.setAdapter(adapterProduct);


        ListCategory = new ListCategory();
        ListCategory.generate_sample_dataset();
        adapterCategory.addAll(ListCategory.getCategories());
    }
}