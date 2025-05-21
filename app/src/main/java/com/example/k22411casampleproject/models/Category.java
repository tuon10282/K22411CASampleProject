package com.example.k22411casampleproject.models;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    private int id;
    private String name;
    private int image_id;
    private ArrayList<Product> products;

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public Category(int image_id, String name, int id) {
        this.image_id = image_id;
        this.name = name;
        this.id = id;
        products=new ArrayList<>();
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
    public void addProduct(Product p)
    {
        products.add(p);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void removeProducts(int id)
    {
        Product p=null;
        for (Product item:products)
        {
            if(item.getId()==id)
            {
                p=item;
                break;
            }
        }
        if(p!=null)
            products.remove(p);
    }
}
