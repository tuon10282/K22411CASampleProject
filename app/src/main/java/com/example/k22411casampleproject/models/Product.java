package com.example.k22411casampleproject.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Product implements Serializable{
    private int id;
    private String name;
    private int quantity;
    private double price;
    private int cateid;

    private int image_id;

    public Product() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public Product(int id, String name, int quantity, double price, int cateid, int image_id) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.cateid = cateid;
        this.image_id = image_id;
    }

    public Product(int id, String name, int quantity, double price, int image_id) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.image_id = image_id;
    }

    @NonNull
    @Override
    public String toString() {
        return id + " - " + name +
                "\nQuantity: " + quantity +
                "\nPrice: " + price +
                "\nCategory ID: " + cateid;
    }

}
