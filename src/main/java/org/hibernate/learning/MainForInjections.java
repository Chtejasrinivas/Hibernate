package org.hibernate.learning;

import org.hibernate.learning.controller.CustomerController;
import org.hibernate.learning.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForInjections {

    public static void main(String[] args) {
        System.out.println("This is the main method for testing the injections in spring framework");

        // we are using the AnnotationConfigApplicationContext because we are using the annotations to configure our beans
        // we need to specify which package we want to scan for the annotations, in this case we are scanning the "org.hibernate.learning" package
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.hibernate.learning");
        CustomerController customerController = applicationContext.getBean(CustomerController.class);
//        Customer customer = customerController.getCustomerViaFieldInjection("Teja Srinivas");
//        Customer customer = customerController.getCustomerViaSetterInjection("Teja Srinivas");
        Customer customer = customerController.getCustomerViaConstructorInjection("Teja Srinivas");
        System.out.println(customer);
    }
}
