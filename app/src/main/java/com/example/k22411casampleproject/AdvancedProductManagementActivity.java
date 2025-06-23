package com.example.k22411casampleproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.adapters.ProductAdapter;
import com.example.k22411casampleproject.models.ListProduct;

public class AdvancedProductManagementActivity extends AppCompatActivity {

    ListView lvProduct;
    ProductAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_advanced_product_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnDraw), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        lvProduct=findViewById(R.id.lvProduct);
        adapter=new ProductAdapter(AdvancedProductManagementActivity.this,
                R.layout.item_advanced_product);
        lvProduct.setAdapter(adapter);

        ListProduct lp=new ListProduct();
        lp.generate_sample_dataset();
        adapter.addAll(lp.getProducts());
    }
}