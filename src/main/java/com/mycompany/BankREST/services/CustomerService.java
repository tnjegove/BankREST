/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BankREST.services;

import com.mycompany.BankREST.models.Customer;
import java.util.ArrayList;

/**
 *
 * @author tadija
 */
public class CustomerService {
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private boolean init = true;

    public CustomerService() {
        if (init) {
            Customer c1 = new Customer(1, "Tadija", "Njegovec", "27 Kildonan road", "tnjegove@gmail.com", "tnjegove", "test123");
            Customer c2 = new Customer(2, "Conor", "Corboy", "Lucan", "conor@gmail.com", "conor", "test321");
            customers.add(c1);
            customers.add(c2);
            init = false;
        }
    }
    
    public ArrayList<Customer> getAllCustomers () {
        return customers;
    }
    
    public Customer getCustomer(int id) {
        return customers.get(id-1);
    }

    public ArrayList<Customer> deleteCustomers() {
        return customers;
    }

    public void deleteCustomers(int id) {
        this.customers.remove(id-1);
    }
    
    
    
}
