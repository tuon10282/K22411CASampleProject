package com.example.k22411casampleproject.models;

import java.util.ArrayList;

public class ListPaymentMethod {
    private ArrayList<PaymentMethod> paymentMethods;

    // Constructor
    public ListPaymentMethod() {
        paymentMethods = new ArrayList<>();
    }

    // Method to generate payment methods
    public void gen_payment_method() {
        paymentMethods.add(new PaymentMethod(1, "Banking Account","Chuyển khoản ngân hàng"));
        paymentMethods.add(new PaymentMethod(2, "Momo","Ví điện tử"));
        paymentMethods.add(new PaymentMethod(3, "Cash","tiền mặt"));
        paymentMethods.add(new PaymentMethod(4, "COD","tiền mặt"));
    }

    // Getter
    public ArrayList<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    // Setter
    public void setPaymentMethods(ArrayList<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
