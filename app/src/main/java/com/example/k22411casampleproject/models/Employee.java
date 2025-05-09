package com.example.k22411casampleproject.models;

public class Employee {
    private String name;
    private String email;
    private String username;
    private String password;
    private boolean saveinfor;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isSaveinfor() {
        return saveinfor;
    }

    public void setSaveinfor(boolean saveinfor) {
        this.saveinfor = saveinfor;
    }

    public Employee() {
    }

    public Employee(String name, String email, String username, String password, boolean saveinfor) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.saveinfor = saveinfor;
    }
}
