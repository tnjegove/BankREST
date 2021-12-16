/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BankREST.databases;

import com.mycompany.BankREST.models.Account;
import com.mycompany.BankREST.models.Customer;
import com.mycompany.BankREST.models.Transaction;
import java.text.SimpleDateFormat;
import java.util.Date;  
import java.util.ArrayList;

/**
 *
 * @author tadija
 */
public class Database {
    public static ArrayList<Customer> customerDB = new ArrayList<Customer>();
    //public static ArrayList<Account> accountDB = new ArrayList<Account>();
    //public static ArrayList<Transaction> transactionDB = new ArrayList<Transaction>();
    public static boolean init = true;

    public Database() {
        if (init) {
            Customer c1 = new Customer(1, "Tadija", "Njegovec", "27 Kildonan road", "tnjegove@gmail.com", "tnjegove", "test123");
            Customer c2 = new Customer(2, "Conor", "Corboy", "Lucan", "conor@gmail.com", "conor", "test321");
            
            System.out.println("test customers added");
            
            Account a1 = new Account (1, "sort001", "41343125623", 20);
            Account a2 = new Account (2, "sort002", "1413125623", 30);
            Account a3 = new Account (1, "sort003", "38569035623", 40);
            Account a4 = new Account (2, "sort004", "123563623", 10);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            Date date = new Date();  
            Transaction t1 = new Transaction(1, 20, 20, date, "transaction description", false);
            Transaction t2 = new Transaction(1, 30, 30, date, "transaction description 1", false);
            Transaction t3 = new Transaction(1, 40, 40, date, "transaction description 2", false);
            Transaction t4 = new Transaction(1, 10, 10, date, "transaction description 3", false);
            a1.setTransaction(t1);
            a2.setTransaction(t2);
            a3.setTransaction(t3);
            a4.setTransaction(t4);
            
            c1.setAccount(a1);
            c1.setAccount(a2);
            c2.setAccount(a3);
            c2.setAccount(a4);
            customerDB.add(c1);
            customerDB.add(c2);
            init = false;
        }
    }

    public static ArrayList<Customer> getCustomerDB() {
        return customerDB;
    }

    public static void setCustomerDB(ArrayList<Customer> customerDB) {
        Database.customerDB = customerDB;
    }
}
