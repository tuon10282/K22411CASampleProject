package com.example.k22411casampleproject.models;
public class Employee {
    private String name;
    private String phone;
    private String email;
    private String username;
    private String password;
    private boolean saveinfor;

    public Employee() {
    }

    public Employee(String name, String phone, String email, String username, String password, boolean saveinfor) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.saveinfor = saveinfor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSaveinfor() {
        return saveinfor;
    }

    public void setSaveinfor(boolean saveinfor) {
        this.saveinfor = saveinfor;
    }
}
