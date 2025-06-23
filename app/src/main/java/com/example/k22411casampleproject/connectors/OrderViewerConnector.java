package com.example.k22411casampleproject.connectors;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.k22411casampleproject.models.OrdersViewer;

import java.util.ArrayList;

public class OrderViewerConnector {

    public ArrayList<OrdersViewer> getAllOrdersViewer(SQLiteDatabase database) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" SELECT ");
        sqlBuilder.append(" Orders.Code AS OrderCode, ");
        sqlBuilder.append(" Orders.OrderDate, ");
        sqlBuilder.append(" Employees.Name AS EmployeeName, ");
        sqlBuilder.append(" Customers.Name AS CustomerName, ");
        sqlBuilder.append(" SUM(OrderDetails.Quantity * OrderDetails.Price * ");
        sqlBuilder.append(" (1 - CAST(REPLACE(OrderDetails.Discount, '%', '') AS REAL) / 100.0) * ");
        sqlBuilder.append(" (1 + CAST(REPLACE(OrderDetails.VAT, '%', '') AS REAL) / 100.0) ) AS TotalOrderValue ");
        sqlBuilder.append(" FROM Orders ");
        sqlBuilder.append(" JOIN Employees ON Orders.EmployeeId = Employees.Id ");
        sqlBuilder.append(" JOIN Customers ON Orders.CustomerId = Customers.Id ");
        sqlBuilder.append(" JOIN OrderDetails ON Orders.Id = OrderDetails.OrderId ");
        sqlBuilder.append(" GROUP BY Orders.Id, Orders.Code, Orders.OrderDate, Employees.Name, Customers.Name ");
        sqlBuilder.append(" ORDER BY Orders.OrderDate DESC; ");

        Cursor cursor = database.rawQuery(sqlBuilder.toString(), null);

        ArrayList<OrdersViewer> datasets = new ArrayList<>();
        while (cursor.moveToNext()) {
            String orderCode = cursor.getString(cursor.getColumnIndexOrThrow("OrderCode"));
            String orderDate = cursor.getString(cursor.getColumnIndexOrThrow("OrderDate"));
            String employeeName = cursor.getString(cursor.getColumnIndexOrThrow("EmployeeName"));
            String customerName = cursor.getString(cursor.getColumnIndexOrThrow("CustomerName"));
            double totalOrderValue = cursor.getDouble(cursor.getColumnIndexOrThrow("TotalOrderValue"));

            OrdersViewer ov = new OrdersViewer();
            ov.setOrderCode(orderCode);
            ov.setOrderDate(orderDate);
            ov.setEmployeeName(employeeName);
            ov.setCustomerName(customerName);
            ov.setTotalOrderValue(totalOrderValue);

            datasets.add(ov);
        }

        cursor.close();
        return datasets;
    }
}
