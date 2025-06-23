package com.example.k22411casampleproject.connectors;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.k22411casampleproject.models.Customer;
import com.example.k22411casampleproject.models.PaymentMethod;

import java.util.ArrayList;

public class PaymentMethodConnector {
    public ArrayList<PaymentMethod> getAllPaymentMethod(SQLiteDatabase database)
    {
        Cursor cursor = database.rawQuery("SELECT * FROM PaymentMethod",
                null);
        ArrayList<PaymentMethod> datasets=new ArrayList<>();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            PaymentMethod pm=new PaymentMethod();
            pm.setId(id);
            pm.setName(name);
            pm.setDescription(description);
            datasets.add(pm);
        }
        cursor.close();
        return datasets;

    }
}
