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
        Category c1 = new Category(1, "Skincare", 100);
        c1.addProduct(new Product(1, "Facial Cleanser", 50, 70, 101));
        c1.addProduct(new Product(2, "Moisturizer", 80, 110, 102));
        c1.addProduct(new Product(3, "Toner", 60, 85, 103));
        c1.addProduct(new Product(4, "Serum", 120, 160, 104));
        c1.addProduct(new Product(5, "Eye Cream", 90, 130, 105));
        categories.add(c1);

        Category c2 = new Category(2, "Makeup", 100);
        c2.addProduct(new Product(6, "Foundation", 120, 160, 106));
        c2.addProduct(new Product(7, "Concealer", 70, 100, 107));
        c2.addProduct(new Product(8, "Blush", 60, 90, 108));
        c2.addProduct(new Product(9, "Mascara", 65, 95, 109));
        c2.addProduct(new Product(10, "Eyeliner", 50, 75, 110));
        categories.add(c2);

        Category c3 = new Category(3, "Lip Care", 100);
        c3.addProduct(new Product(11, "Lip Balm", 30, 45, 111));
        c3.addProduct(new Product(12, "Lip Scrub", 35, 50, 112));
        c3.addProduct(new Product(13, "Tinted Lip Balm", 40, 60, 113));
        c3.addProduct(new Product(14, "Lip Mask", 45, 65, 114));
        c3.addProduct(new Product(15, "Lipstick", 70, 100, 115));
        categories.add(c3);

        Category c4 = new Category(4, "Hair Care", 100);
        c4.addProduct(new Product(16, "Shampoo", 90, 130, 116));
        c4.addProduct(new Product(17, "Conditioner", 85, 120, 117));
        c4.addProduct(new Product(18, "Hair Oil", 70, 100, 118));
        c4.addProduct(new Product(19, "Hair Mask", 100, 140, 119));
        c4.addProduct(new Product(20, "Heat Protectant", 95, 135, 120));
        categories.add(c4);

        Category c5 = new Category(5, "Body Care", 100);
        c5.addProduct(new Product(21, "Body Wash", 70, 95, 121));
        c5.addProduct(new Product(22, "Body Lotion", 60, 85, 122));
        c5.addProduct(new Product(23, "Body Scrub", 75, 100, 123));
        c5.addProduct(new Product(24, "Hand Cream", 40, 60, 124));
        c5.addProduct(new Product(25, "Foot Cream", 45, 65, 125));
        categories.add(c5);

        Category c6 = new Category(6, "Sunscreen", 100);
        c6.addProduct(new Product(26, "SPF 30", 80, 110, 126));
        c6.addProduct(new Product(27, "SPF 50+", 100, 140, 127));
        c6.addProduct(new Product(28, "Tinted Sunscreen", 90, 130, 128));
        c6.addProduct(new Product(29, "Sunblock Stick", 60, 85, 129));
        c6.addProduct(new Product(30, "Sunscreen Spray", 95, 125, 130));
        categories.add(c6);

        Category c7 = new Category(7, "Face Mask", 100);
        c7.addProduct(new Product(31, "Clay Mask", 40, 60, 131));
        c7.addProduct(new Product(32, "Sheet Mask", 25, 40, 132));
        c7.addProduct(new Product(33, "Peel-Off Mask", 50, 75, 133));
        c7.addProduct(new Product(34, "Sleeping Mask", 70, 95, 134));
        c7.addProduct(new Product(35, "Hydrogel Mask", 60, 85, 135));
        categories.add(c7);

        Category c8 = new Category(8, "Fragrance", 100);
        c8.addProduct(new Product(36, "Perfume", 150, 200, 136));
        c8.addProduct(new Product(37, "Body Mist", 90, 120, 137));
        c8.addProduct(new Product(38, "Eau de Toilette", 120, 160, 138));
        c8.addProduct(new Product(39, "Roll-On Perfume", 60, 90, 139));
        c8.addProduct(new Product(40, "Solid Perfume", 70, 100, 140));
        categories.add(c8);

        Category c9 = new Category(9, "Nail Care", 100);
        c9.addProduct(new Product(41, "Nail Polish", 30, 50, 141));
        c9.addProduct(new Product(42, "Nail Remover", 20, 35, 142));
        c9.addProduct(new Product(43, "Cuticle Oil", 25, 40, 143));
        c9.addProduct(new Product(44, "Base Coat", 35, 55, 144));
        c9.addProduct(new Product(45, "Top Coat", 35, 55, 145));
        categories.add(c9);

        Category c10 = new Category(10, "Men's Grooming", 100);
        c10.addProduct(new Product(46, "Beard Oil", 70, 100, 146));
        c10.addProduct(new Product(47, "Aftershave Balm", 60, 90, 147));
        c10.addProduct(new Product(48, "Face Wash for Men", 55, 80, 148));
        c10.addProduct(new Product(49, "Hair Gel", 40, 60, 149));
        c10.addProduct(new Product(50, "Men’s Deodorant", 50, 75, 150));
        categories.add(c10);
    }

}
