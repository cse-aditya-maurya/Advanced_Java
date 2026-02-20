package com.capegemini.relation.Jpa_Unidirectional_One_to_One_Mapping;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory factory =
            new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Locker.class)
                    .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}










