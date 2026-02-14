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

//        Laptop laptop = session.find(Laptop.class, 2);
//        Laptop laptop = session.getReference(Laptop.class, 2);

        /**
         * Find will fire a query no matter what you use the data or not (in this case we are using the data to print it)
         * getReference will not fire a query until you use the data (in this case we are using the data to print it)
         * so here we can say getReference is being used as lazy loading and find is being used as eager loading.
        */

        Laptop laptop = session.getReference(Laptop.class,2);
        System.out.println(laptop);
        session.close();

        sf.close();


    }

}