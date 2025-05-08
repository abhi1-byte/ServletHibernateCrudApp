package com.example.utils;

import com.example.dto.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    private static Session session = null;

    private HibernateUtil() {
    }

    static {
        sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
    }

    public static Session getSession() {
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public static void closeSession() {
        if (session != null) {
            session.close();
            System.out.println("Session closed");
        }
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
            System.out.println("Session Factory closed");
        }
    }

    public static void startup() {
        System.out.println("*****Hibernate set up has started ******");
    }
}
