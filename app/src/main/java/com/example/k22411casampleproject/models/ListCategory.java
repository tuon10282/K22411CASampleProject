package com.example.k22411casampleproject.models;

import java.util.ArrayList;

public class ListCategory {
    private ArrayList<Category> categories;

    public ListCategory() {
        categories = new ArrayList<>();
    }

    public void addCategory(Category c) {
        categories.add(c);
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void generate_sample_dataset() {
        addCategory(new Category(1, "Thời trang"));
        addCategory(new Category(2, "Công nghệ"));
        addCategory(new Category(3, "Đồ gia dụng"));
        addCategory(new Category(4, "Sách vở"));
        addCategory(new Category(5, "Phụ kiện học sinh"));
        addCategory(new Category(6, "Mỹ phẩm"));
        addCategory(new Category(7, "Thực phẩm chức năng"));
        addCategory(new Category(8, "Trang sức"));
        addCategory(new Category(9, "Thiết bị học tập"));
        addCategory(new Category(10, "Khác"));
    }
}
