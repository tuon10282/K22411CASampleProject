package com.example.k22411casampleproject.models;

import com.example.k22411casampleproject.R;

import java.util.ArrayList;

public class ListProduct {
    private ArrayList<Product> products;

    public ListProduct() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void generate_sample_dataset() {
        addProduct(new Product(1, "Facial Cleanser", 50, 70, R.mipmap.ic_facial));
        addProduct(new Product(2, "Moisturizer", 80, 110, R.mipmap.ic_moisturizer));
        addProduct(new Product(3, "Toner", 60, 85, R.mipmap.ic_toner));
        addProduct(new Product(4, "Serum", 120, 160, R.mipmap.ic_serum));
        addProduct(new Product(5, "Eye Cream", 90, 130, R.mipmap.ic_eyecream));
    }
}
