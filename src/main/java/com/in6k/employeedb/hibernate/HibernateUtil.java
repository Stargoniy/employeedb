package com.in6k.employeedb.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    protected static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            return new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
