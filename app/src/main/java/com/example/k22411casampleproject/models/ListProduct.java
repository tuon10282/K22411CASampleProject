package com.example.k22411casampleproject.models;

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
        addProduct(new Product(1, "Áo thun GenZ", 50, 199000, 1)); // Thời trang
        addProduct(new Product(2, "Tai nghe Bluetooth", 30, 499000, 2)); // Công nghệ
        addProduct(new Product(3, "Bàn học thông minh", 10, 899000, 3)); // Đồ gia dụng
        addProduct(new Product(4, "Sách kỹ năng mềm", 100, 79000, 4)); // Sách vở
        addProduct(new Product(5, "Balo học sinh", 20, 350000, 5)); // Phụ kiện học sinh
        addProduct(new Product(6, "Son dưỡng môi", 80, 129000, 6)); // Mỹ phẩm
        addProduct(new Product(7, "Vitamin C dạng viên", 40, 159000, 7)); // Thực phẩm chức năng
        addProduct(new Product(8, "Dây chuyền bạc", 15, 229000, 8)); // Trang sức
        addProduct(new Product(9, "Máy tính cầm tay", 25, 199000, 9)); // Thiết bị học tập
        addProduct(new Product(10, "Đèn LED trang trí", 60, 99000, 10)); // Khác
    }
}
