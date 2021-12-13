/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BankREST.databases;

import com.mycompany.BankREST.models.Account;
import com.mycompany.BankREST.models.Customer;
import com.mycompany.BankREST.models.Transaction;
import java.util.ArrayList;

/**
 *
 * @author tadija
 */
public class Database {
    public static ArrayList<Customer> customerDB = new ArrayList<Customer>();
    public static ArrayList<Account> accountDB = new ArrayList<Account>();
    public static ArrayList<Transaction> transactionDB = new ArrayList<Transaction>();
    public static boolean init = true;

    public Database() {
        if (init) {
            Customer c1 = new Customer(1, "Tadija", "Njegovec", "27 Kildonan road", "tnjegove@gmail.com", "tnjegove", "test123");
            Customer c2 = new Customer(2, "Conor", "Corboy", "Lucan", "conor@gmail.com", "conor", "test321");
            customerDB.add(c1);
            customerDB.add(c2);
            System.out.println("test customers added");
            init = false;
        }
    }

    public static ArrayList<Customer> getCustomerDB() {
        return customerDB;
    }

    public static void setCustomerDB(ArrayList<Customer> customerDB) {
        Database.customerDB = customerDB;
    }

    public static ArrayList<Account> getAccountDB() {
        return accountDB;
    }

    public static void setAccountDB(ArrayList<Account> accountDB) {
        Database.accountDB = accountDB;
    }

    public static ArrayList<Transaction> getTransactionDB() {
        return transactionDB;
    }

    public static void setTransactionDB(ArrayList<Transaction> transactionDB) {
        Database.transactionDB = transactionDB;
    }
    
    
    
}
