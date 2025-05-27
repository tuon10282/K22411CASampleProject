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

import com.example.k22411casampleproject.models.Customer;
import com.example.k22411casampleproject.models.ListCustomer;

import org.jetbrains.annotations.Nullable;


public class CustomerManagementActivity extends AppCompatActivity {
    ListView lvCustomer;
    ArrayAdapter<Customer> adapter;
    ListCustomer lc=new ListCustomer();

    MenuItem menu_new_customer;

    MenuItem menu_broadcast;
    MenuItem menu_help;

    final int ID_CREATE_NEW_CUSTOMER=1;
    final int ID_UPDATE_CUSTOMER=2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }
    private void addEvents() {
        lvCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Customer c=adapter.getItem(i);
                openCustomerDetailActivity(c);
            }
        });
    }

    private void openCustomerDetailActivity(Customer c) {
        Intent intent=new Intent(CustomerManagementActivity.this,
                CustomerDetailActivity.class);
        intent.putExtra("SELECTED_CUSTOMER",c);
        startActivity(intent);

    }

    private void addViews() {
        lvCustomer=findViewById(R.id.lvCustomer);
        adapter=new ArrayAdapter<>(
                CustomerManagementActivity.this,
                android.R.layout.simple_list_item_1);
        lc.generate_sample_dataset();
        adapter.addAll(lc.getCustomers());
        adapter.notifyDataSetChanged();

        lvCustomer.setAdapter(adapter);
        menu_new_customer=findViewById(R.id.menu_new_customer);
        menu_broadcast=findViewById(R.id.menu_broadcast);
        menu_help=findViewById(R.id.menu_help);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu_customer,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_new_customer)
        {
            Toast.makeText(CustomerManagementActivity.this,"Mở màn hình thêm khách hàng mới",Toast.LENGTH_LONG).show();
            openNewCustomerActivity();
        }
        else if (item.getItemId()==R.id.menu_broadcast)
        {
            Toast.makeText(CustomerManagementActivity.this,"Bấm Tin quảng cáo",Toast.LENGTH_LONG).show();
        }
        else if (item.getItemId()==R.id.menu_help)
        {
            Toast.makeText(CustomerManagementActivity.this,"Trợ giúp",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openNewCustomerActivity() {
        Intent intent = new Intent(CustomerManagementActivity.this, CustomerDetailActivity.class);
//        startActivity(intent);
        startActivityForResult(intent,ID_CREATE_NEW_CUSTOMER);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode, data );
        if(requestCode==ID_CREATE_NEW_CUSTOMER && resultCode==1000)
        {
            Customer c= (Customer) data.getSerializableExtra("NEW_CUSTOMER");
            // CÓ HAI TÌNH HUỐNG
            // lưu mới hay lưu cập nhật
            process_save_customer(c);
        }
    }

    private void process_save_customer(Customer c) {
        boolean result=lc.isExisting(c);
        if(result==true) // tức đã tồn tại
            return; // không thêm mới
        //còn nếu ta muốn cập nhật thì viết code cập nhật
        lc.addCustomer(c);
        adapter.clear();
        adapter.addAll(lc.getCustomers());
    }

}
