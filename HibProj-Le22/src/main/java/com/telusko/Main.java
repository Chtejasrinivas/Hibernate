package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(com.telusko.Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        Laptop l1 = session.find(Laptop.class, 2);
        System.out.println(l1);
        session.close();

        // here we are creating two session to demonstrate becuase of L2 cache is not implemented by default 
        // two get queries are fired to access the same data even tough it's not changed in this case. 
        Session session1 = sf.openSession();
        Laptop l2 = session1.find(Laptop.class, 2);
        System.out.println(l2);

        session1.close();

        sf.close();


    }

}
