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
        ArrayList<Account> tmp = null;
        System.out.println("Number of customers: "+customers.size());
        try {
            tmp = (ArrayList<Account>)customers.get(id-1).getAccounts();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("array out of bounds.");
        }
        
        return tmp;
    }
    
    public Account getAccountID(int customerID, int accountID) {
        ArrayList<Account> tmpAccs = null;
        Account tmpAcc = null;
        try {
            tmpAccs = customers.get(customerID-1).getAccounts();
            tmpAcc = tmpAccs.get(accountID-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("array index out of bounds");
        }
        return tmpAcc;
    }
    
    public ArrayList<Account> setAccount(int customerID, Account account) {
        ArrayList<Account> tmpAccs = null;
        try {
            tmpAccs = customers.get(customerID-1).getAccounts();
            account.setAccountID(tmpAccs.size()+1);
            tmpAccs.add(account); // add new account to arraylist
            customers.get(customerID-1).setAccounts(tmpAccs);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Array out of bounds");
        }
        return tmpAccs;
    }
    
    public ArrayList<Account> deleteAccount(int customerID, int accountID) {
        ArrayList<Account> tmpAccs = null;
        try {
            tmpAccs = customers.get(customerID-1).getAccounts();
            tmpAccs.remove(accountID-1);
            customers.get(customerID-1).setAccounts(tmpAccs);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Array out of bounds");
        }
        return tmpAccs;
    }
    
    public double getBalance(int customerID, int accountID) {
        double tmpBalance = 0;
        try {
            tmpBalance = customers.get(customerID).getAccounts().get(accountID).getCurrentBalance();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Array out of bounds");
        }
        return tmpBalance;
    }
    
    
}
