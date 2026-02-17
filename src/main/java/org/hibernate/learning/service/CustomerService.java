package org.hibernate.learning.service;


import org.hibernate.learning.model.Customer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class CustomerService {

    private int serviceVariable;

    public Customer fetchCustomer(String name) {
        Customer cus  = new Customer(1, name, name + "@example.com");
        System.out.println("Fetching users from repo");
        return cus;
    }

    public void setServiceVariable(int serviceVariable) {
        this.serviceVariable = serviceVariable;
    }

    public int getServiceVariable() {
        return serviceVariable;
    }
}
