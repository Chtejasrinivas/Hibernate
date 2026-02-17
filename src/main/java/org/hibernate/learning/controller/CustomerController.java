package org.hibernate.learning.controller;

import org.hibernate.learning.model.Customer;
import org.hibernate.learning.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Run the main method in MainForInjections class to test the different types of dependency injections in spring framework.
 */

@Controller
public class CustomerController {

    // without having the Autowire I will get NPE because I have not initialized the customerService variable
    // and I am trying to call the fetchCustomer method on it.

    // Field Injection -> injecting directly field
//    @Autowired
//    private CustomerService customerService;

//    @Autowired
//    private CustomerService customerService1;

//    public Customer getCustomerViaFieldInjection(String customerName){
//
//        // setting customer variable to 10 for customer service object
//        customerService1.setServiceVariable(10);
//        // This prints 10
//        System.out.println(customerService1.getServiceVariable());
//
//        // this prints 0 since for customer service object the value is not being set
//        System.out.println("Before change: " + customerService.getServiceVariable());
//
//        // since via field injections the beans are mutable I can do this
//        customerService = customerService1;
//
//        // This will print 10 since now both customerService and customerService1 are pointing to the same object in the memory and the value of serviceVariable is 10 for that object.
//        System.out.println("After change: " + customerService.getServiceVariable());
//
        /**
         one more thing we can do with field is we can make the dependency injection as optional by setting
         required false, this way if no bean is created for service class also fine till we don't call the method on that object,
         if we call the method on that object then we will get NPE because the object is not initialized.

         Try to remove the @Service annotation in service class and make the import like below in this class.
         @Autowired(required = false)
         private CustomerService customerService;

         */
//        return customerService.fetchCustomer(customerName);
//    }

//     Setter Injection -> injecting through setter method

//        private CustomerService customerService;
//        @Autowired
//        public void setCustomerService(CustomerService customerService) {
//            this.customerService = customerService;
//        }
//
//        public Customer getCustomerViaSetterInjection(String customerName){
//
            /**
             * 1. using this approach also we can achieve mutability
             * 2. optional dependency injection like we did in field injection approach, we just need to set the required attribute of @Autowired annotation to false.
             * 3. This approach is useful when you write the unit test cases rather than using reflections to set the field name of service we can directly call the setter
              * 4. Here the dependency is being injection after the object is created since we are using setter method.
             */
//
//            /**
//             * Imagine we are writing unite test cases for this controller with this approach in Test class we can
//             *
//             * @InjectMocks
//             * private CustomerController customerController
//             * private CustomerService customerServiceObj = new CustomerService();
//             * customerController.setCustomerService(customerServiceObj)
//             *
//             * without this setter method we need to use reflection to set the value of customerService variable in the controller class which is not a good practice.
//             * ReflectionTestUtils.setField(customerController, "customerService", customerServiceObj);
//             */
//            return customerService.fetchCustomer(customerName);
//        }

        // Constructor Injection -> injecting through constructor
        private final CustomerService customerService;
        @Autowired
        public CustomerController(CustomerService customerService) {
            this.customerService = customerService;
        }

        public Customer getCustomerViaConstructorInjection(String customerName) {
            /**
             * 1. using this approach also we can achieve immutability since we are injecting the dependency through constructor and we are not providing any setter method to change the value of customerService variable.
             * 2. This approach is useful when you want to make sure that the dependency is not null and it is initialized before using it, because if we try to create an object of controller class without providing the service object then we will get compilation error.
             * 3. This approach is also useful when you want to write unit test cases for this controller class, because we can directly call the constructor and pass the service
             * 4. Here the dependency is being injection before the object is created since we are using constructor.
             **/
            return customerService.fetchCustomer(customerName);
        }


}
