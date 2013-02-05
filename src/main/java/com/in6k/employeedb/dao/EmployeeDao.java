package com.in6k.employeedb.dao;

import com.in6k.employeedb.entity.Employee;
import com.in6k.employeedb.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDao {
    public static void save(Employee employee) {
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }
}
