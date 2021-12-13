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


public class AccountService {
    private static ArrayList<Customer> customers = new Database().getCustomerDB();
    //private static ArrayList<Account> accounts = new ArrayList<Account>();
    public AccountService() {
        
    }
    
    public ArrayList<Account> getAllAccounts(int id) {
        ArrayList<Account> tmp;
        System.out.println("Number of customers: "+customers.size());
        tmp = (ArrayList<Account>)customers.get(id-1).getAccounts();
        
        return tmp;
    }
    
    
}
