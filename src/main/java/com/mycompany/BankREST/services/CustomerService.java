/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BankREST.services;

import com.mycompany.BankREST.databases.Database;
import com.mycompany.BankREST.models.Account;
import com.mycompany.BankREST.models.Customer;
import java.util.ArrayList;

/**
 *
 * @author tadija
 */
public class CustomerService {
    Database d = new Database();
    private ArrayList<Customer> customers = d.getCustomerDB();
    //private static boolean init = true;

    /*public CustomerService() {
        if (init) {
            Customer c1 = new Customer(1, "Tadija", "Njegovec", "27 Kildonan road", "tnjegove@gmail.com", "tnjegove", "test123");
            Customer c2 = new Customer(2, "Conor", "Corboy", "Lucan", "conor@gmail.com", "conor", "test321");
            customers.add(c1);
            customers.add(c2);
            System.out.println("test customers added");
            init = false;
        }
    }*/
    
    public ArrayList<Customer> getAllCustomers () {
        return customers;
    }
    
    public Customer getCustomer(int id) {
        Customer tmpCustomer = null;
        try {
            tmpCustomer = customers.get(id-1);
        } catch (IndexOutOfBoundsException e) {
            tmpCustomer = null;
            System.out.println("Customer array out of bounds.");
        }
        return tmpCustomer;
    }

    
    public ArrayList<Customer> deleteCustomer(int id) {
        try {
            customers.remove(id-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Customer array out of bounds.");
        }
        return customers;
    }
    
    public Customer addCustomer(Customer tmp) {
        tmp.setCustomerID(customers.size()+1);
        ArrayList<Account> tmpAccs = new ArrayList<Account>();
        tmp.setAccounts(tmpAccs);
        customers.add(tmp);   
        System.out.println("new customer added");
        return tmp;
    }
    
    
    
}
