package com.example.k22411casampleproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapters.OrdersViewerAdapter;
import com.example.k22411casampleproject.connectors.OrderViewerConnector;
import com.example.k22411casampleproject.connectors.SQLiteConnector;
import com.example.k22411casampleproject.models.OrdersViewer;

import java.util.ArrayList;

public class OrdersViewerActivity extends AppCompatActivity {
    ListView lvOrdersViewer;
    OrdersViewerAdapter adapter; // BỔ SUNG biến adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_viewer);
        addViews();
    }

    private void addViews() {
        lvOrdersViewer = findViewById(R.id.lvOrdersViewer);

        // Khởi tạo adapter với danh sách rỗng ban đầu
        adapter = new OrdersViewerAdapter(this, R.layout.item_ordersviewer, new ArrayList<>());
        lvOrdersViewer.setAdapter(adapter);

        // Mở database và load dữ liệu
        SQLiteConnector connector = new SQLiteConnector(this); // sửa lại từ context:this
        OrderViewerConnector ovc = new OrderViewerConnector();
        ArrayList<OrdersViewer> dataset = ovc.getAllOrdersViewer(connector.openDatabase());

        // Đổ dữ liệu vào adapter
        adapter.clear();
        adapter.addAll(dataset);
        adapter.notifyDataSetChanged(); // thông báo adapter cập nhật
    }
}
