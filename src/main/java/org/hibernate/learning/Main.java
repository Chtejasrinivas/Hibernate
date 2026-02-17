package org.hibernate.learning;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.learning.model.Customer;
import org.hibernate.learning.model.CustomerOrder;

import java.util.Properties;

// Refer here for Hibernate concept

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer(101, "teja", "123@gmail.com");

        // creating new config object and setting the properties for the database connection
        Configuration configuration = new Configuration();

        // When you try to fetch the data from the database, you need to tell hibernate which class is mapped to which table in the database.
        // without this Hibernate will throw an error because it will not know which class is mapped to which table in the database.
        // since we put only customer here only customer table will be created.
        // comment the below line and check the error

//        configuration.addAnnotatedClass();

        // to give multiple classes.
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(CustomerOrder.class);

        // creating properties object and setting the properties for the database connection
        Properties properties = getProperties();
        configuration.addProperties(properties);

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();

//        Transaction transaction = session.beginTransaction();

        // .save method in Jpa
//        session.persist(c1);

        // without commiting the transaction the data will not be saved to the database,
        // so we need to commit the transaction to save the data to the database.
//        transaction.commit();

        session.close();
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/demo");
        properties.setProperty("hibernate.connection.username", "demo");
        properties.setProperty("hibernate.connection.password", "demo");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.show_sql", "true");
        return properties;
    }
}