package com.example.k22411casampleproject.connectors;

import com.example.k22411casampleproject.models.Employee;
import com.example.k22411casampleproject.models.ListEmployee;

public class EmployeeConnector {
    public Employee login(String usr, String pwd)
    {
        ListEmployee le=new ListEmployee();
        for(Employee e : le.getEmployees())
        {
            if(e.getUsername().equalsIgnoreCase(usr) && e.getPassword().equals(pwd))
            {
                return e;
            }
        }
        return null;
    }
}
