package com.example.k22411casampleproject.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ListCustomer {
    private ArrayList<Customer> customers;
    SQLiteDatabase database=null;


    public ListCustomer() {
        customers=new ArrayList<>();
    }
    public void addCustomer (Customer c)
    {
        customers.add(c);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    public void generate_sample_dataset()
    {
        addCustomer(new Customer(1, "Teo", "teo@gmail.com", "0123456789", "teo", "123"));
        addCustomer(new Customer(2, "Ty", "ty@gmail.com", "0983845321", "ty", "123"));
        addCustomer(new Customer(3, "Meo", "meo@gmail.com", "0123456789", "meo", "123"));
        addCustomer(new Customer(4, "Hui", "hui@gmail.com", "0123456789", "hui", "123"));
        addCustomer(new Customer(5, "Kie", "kie@gmail.com", "0123456789", "kie", "123"));
        addCustomer(new Customer(6, "Map", "map@gmail.com", "0123456789", "map", "123"));
        addCustomer(new Customer(7, "Tuong", "tuong@gmail.com", "0123456789", "tuong", "123"));
        addCustomer(new Customer(8, "Xeo", "xeo@gmail.com", "0123456789", "xeo", "123"));
        addCustomer(new Customer(9, "Kioe", "kioe@gmail.com", "0123456789", "kioe", "123"));
        addCustomer(new Customer(10, "Kak", "kak@gmail.com", "0123456789", "kak", "123"));
    }
    public boolean isExisting(Customer c)
    {
        for(Customer cus: customers)
        {
            if(cus.getId()== c.getId() ||
            cus.getPhone().equals(c.getPhone()) ||
            cus.getEmail().equalsIgnoreCase(c.getEmail()) ||
            cus.getUsername().equalsIgnoreCase(c.getUsername())
            )
            return true;
        }
        return false;
    }
    public void getAllCustomers(SQLiteDatabase database)
    {
        Cursor cursor = database.rawQuery("SELECT * FROM Customers",
                null);
        customers.clear();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            String email = cursor.getString(3);
            String username = cursor.getString(4);
            String password = cursor.getString(5);
            int saveInfor=cursor.getInt(6);
            Customer c=new Customer();
            c.setId(id);
            c.setName(name);
            c.setPhone(phone);
            c.setEmail(email);
            c.setUsername(username);
            c.setPassword(password);
            customers.add(c);
        }
        cursor.close();
    }

}

