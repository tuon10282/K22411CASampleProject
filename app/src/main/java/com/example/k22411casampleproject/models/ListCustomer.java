package com.example.k22411casampleproject.models;

import java.util.ArrayList;

public class ListCustomer {
    private ArrayList<Customer> customers;

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
}

