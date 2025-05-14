package com.example.k22411casampleproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.k22411casampleproject.models.Product;
import com.example.k22411casampleproject.models.ListProduct;

public class ProductManagementActivity extends AppCompatActivity {
    ListView lvProduct;
    ArrayAdapter<Product> adapter;
    ListProduct lp = new ListProduct();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        lvProduct = findViewById(R.id.lvProduct);
        adapter = new ArrayAdapter<>(
                ProductManagementActivity.this,
                android.R.layout.simple_list_item_1);
        lp.generate_sample_dataset();
        adapter.addAll(lp.getProducts());
        lvProduct.setAdapter(adapter);
    }
}
