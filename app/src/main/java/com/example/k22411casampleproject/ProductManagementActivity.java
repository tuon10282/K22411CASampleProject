package com.example.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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

    MenuItem menu_category;

    MenuItem menu_addproduct;
    MenuItem menu_inventory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnDraw), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Product p=adapter.getItem(i);
                openProductDetailActivity(p);
            }
        });

    }

    private void openProductDetailActivity(Product p) {
        Intent intent=new Intent(ProductManagementActivity.this,
                ProductDetailActivity.class);
        intent.putExtra("SELECTED_PRODUCT",p);
        startActivity(intent);

    }

    private void addViews() {
        lvProduct = findViewById(R.id.lvProduct);
        adapter = new ArrayAdapter<>(
                ProductManagementActivity.this,
                android.R.layout.simple_list_item_1);
        lp.generate_sample_dataset();
        adapter.addAll(lp.getProducts());

        lvProduct.setAdapter(adapter);
        menu_category=findViewById(R.id.menu_category);
        menu_addproduct=findViewById(R.id.menu_addproduct);
        menu_inventory=findViewById(R.id.menu_inventory);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_main_product,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_category)
        {
            Toast.makeText(ProductManagementActivity.this,"Mở màn hình Category",Toast.LENGTH_LONG).show();
            openNewProductActivity();
        }
        else if (item.getItemId()==R.id.menu_addproduct)
        {
            Toast.makeText(ProductManagementActivity.this,"Thêm sản phẩm",Toast.LENGTH_LONG).show();
        }
        else if (item.getItemId()==R.id.menu_inventory)
        {
            Toast.makeText(ProductManagementActivity.this,"Mở Tồn kho",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openNewProductActivity() {
        //hôm sau làm (26/05)
    }
}

