package com.in6k.employeedb;

import com.in6k.employeedb.dao.EmployeeDao;
import com.in6k.employeedb.entity.Employee;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setFirstName("jon");
        employee.setLastName("ivanov");
        employee.setEmail("petrov@gmail.com");
        employee.setPassword("123");
        employee.setBirhdate("12-11-1991");

        EmployeeDao.save(employee);
    }
}
