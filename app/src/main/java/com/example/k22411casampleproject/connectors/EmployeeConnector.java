package com.example.k22411casampleproject.connectors;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.k22411casampleproject.models.Employee;
import com.example.k22411casampleproject.models.ListEmployee;
public class EmployeeConnector {
    Activity context;
    String DATABASE_NAME="SalesDatabase.db";
    private static final String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database=null;
    public EmployeeConnector()
    {

    }

    public EmployeeConnector(Activity context) {

        this.context = context;
    }
    public Employee login(Activity context, String usr, String pwd)
    {
        //Tiến hay truy vấn SQLite Database
        database = context.openOrCreateDatabase(DATABASE_NAME,
                context.MODE_PRIVATE, null);

        Cursor cursor = database.rawQuery(
                "SELECT * FROM Employees WHERE UserName =? AND Password=?",
                new String[]{usr,pwd});
        Employee emp=null;
        if(cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone=cursor.getString(2);
            String email=cursor.getString(3);
            String username=cursor.getString(4);
            String password=cursor.getString(5);
            int saveInfor=cursor.getInt(6);
            emp=new Employee();
            emp.setName(name);
            emp.setEmail(email);
            emp.setUsername(username);
            emp.setPassword(password);
            emp.setPhone(phone);
            emp.setSaveinfor(saveInfor==1?true:false);
        }
        cursor.close();

        return emp;
    }

    public Employee login(String usr, String pwd)
    {
        ListEmployee le=new ListEmployee();
        le.generate_sample_dataset();
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
