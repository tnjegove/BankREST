/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BankREST.services;

import com.mycompany.BankREST.databases.Database;
import com.mycompany.BankREST.models.Account;
import com.mycompany.BankREST.models.Customer;
import com.mycompany.BankREST.models.Transaction;
import java.util.ArrayList;

/**
 *
 * @author tadija
 */
public class TransactionService {
    private static ArrayList<Customer> customers = new Database().getCustomerDB();

    public TransactionService() {
    }
    
    public ArrayList<Transaction> getAllTransactions (int customerID, int accountID) {        
        ArrayList<Account> tmpAccounts;
        tmpAccounts = (ArrayList<Account>)customers.get(customerID-1).getAccounts();
        //find an account with id accountID in arraylist of accounts
        Account tmpAcc = tmpAccounts.get(accountID-1);
        return tmpAcc.getTransactions();
    }
    
    public Transaction getTransaction(int customerID, int accountID, int transactionID) {
        ArrayList<Account> tmpAcc = customers.get(customerID-1).getAccounts();
        ArrayList<Transaction> tmpTrans = tmpAcc.get(accountID-1).getTransactions();
        Transaction tmpTran = tmpTrans.get(transactionID-1);        
        return tmpTran;
        
    }
    
    public ArrayList<Transaction> setTransaction(int customerID, int accountID, Transaction transaction) {
        ArrayList<Account> tmpAcc = customers.get(customerID-1).getAccounts(); // get list of accounts for customerID
        ArrayList<Transaction> tmpTrans = tmpAcc.get(accountID-1).getTransactions(); // get list of transactions for accountID
        tmpTrans.add(transaction);//add new transaction to list of transactions 
        tmpAcc.get(accountID-1).setTransactions(tmpTrans);//replace existing list of transactions with new updated list of transactions
        customers.get(customerID-1).setAccounts(tmpAcc);//update customers
        return tmpTrans;
    
    }
    
}
