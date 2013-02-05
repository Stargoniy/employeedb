package com.in6k.employeedb.dao;

import com.in6k.employeedb.entity.Employee;
import com.in6k.employeedb.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDao {
    public static void save(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    public static List<Employee> findAllEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> result = session.createCriteria(Employee.class).list();
        session.close();
        return result;
    }

    public static Employee findEmployeeById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee result = (Employee) session.get(Employee.class, id);
//        session.
        session.close();
        return result;
    }
}
