package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        /** Here we tried to create a student class we tried to save the data to DB.
         * since we have not given the url's for the database and the username and password for the database we will get an error.
          * we will see the error in the console,
         * Then we will fix it by giving the url's for the database and the username and password for the database
         * In the next Directory.
         */
        Student s1 = new Student();
        s1.setRollNo(101);
        s1.setsName("Navin");
        s1.setsAge(30);
        Configuration cfg=new Configuration();
        SessionFactory sf=cfg.buildSessionFactory();
        Session session = sf.openSession();
        session.persist(s1);

        System.out.println(s1);

    }

}