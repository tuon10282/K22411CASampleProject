package com.example.k22411casampleproject.models;

import java.util.ArrayList;
import java.util.List;

public class ListEmployee {
    private List<Employee> employees;

    public ListEmployee() {
        employees=new ArrayList<>();
        generate_sample_dataset();
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void generate_sample_dataset()
    {
        Employee e1 =new Employee();
        e1.setName("John");
        e1.setEmail("john@gmail.com");
        e1.setUsername("John");
        e1.setPassword("123");

        Employee e2=new Employee();
        e2.setName("Tome");
        e2.setEmail("Tom@gmail.com");
        e2.setUsername("Tom");
        e2.setPassword("123");

        Employee e3=new Employee();
        e3.setName("Khum");
        e3.setEmail("john@gmail.com");
        e3.setUsername("Han");
        e3.setPassword("123");

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);


    }

}
