package com.capegemini.relation.OneToManyUnidirectional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.capegemini.relation.Jpa_Unidirectional_One_to_One_Mapping.HibernateUtil;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee e1 = new Employee(101, "Ravi", "Developer", 50000);
        Employee e2 = new Employee(102, "Priya", "Tester", 45000);

        Department dept = new Department(
                1,
                "IT",
                "Bangalore",
                Arrays.asList(e1, e2)
        );

        session.persist(dept); // saves department + employees

        tx.commit();

        Department fetched = session.get(Department.class, 1);
        System.out.println("Fetched: " + fetched);

        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
