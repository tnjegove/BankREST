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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tadija
 */
public class TransactionService {
    private static ArrayList<Customer> customers = new Database().getCustomerDB();

    public TransactionService() {
    }
    
    public ArrayList<Transaction> getAllTransactions (int customerID, int accountID) {        
        ArrayList<Account> tmpAccounts = null;
        ArrayList<Transaction> tmpTrans = null;
        try {
            tmpAccounts = (ArrayList<Account>)customers.get(customerID-1).getAccounts();
            //find an account with id accountID in arraylist of accounts
            tmpTrans = (ArrayList<Transaction>)tmpAccounts.get(accountID-1).getTransactions(); //get transaction list from account
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds.");
        }
        return tmpTrans;
    }
    
    public Transaction getTransaction(int customerID, int accountID, int transactionID) {
        Transaction tmpTran = null;
        try {
            tmpTran = customers.get(customerID-1).getAccounts().get(accountID-1).getTransactions().get(transactionID-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds.");
        }                       
        return tmpTran;
        
    }
    
    public ArrayList<Transaction> setTransaction(int customerID, int accountID, Transaction transaction) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date(); 
        transaction.setCreated(date);
        double currentBalance=0, transactionAmount = 0;
        ArrayList<Transaction> tmpTrans = null;
        try {
            tmpTrans = customers.get(customerID-1).getAccounts().get(accountID-1).getTransactions(); // get list of transactions for accountID
            transaction.setTransactionID(tmpTrans.size()+1);        
            currentBalance = customers.get(customerID).getAccounts().get(accountID-1).getCurrentBalance();
            transactionAmount = transaction.getAmount();
            if (transaction.isWithdrawal()) {
                if (currentBalance-transactionAmount<0) {
                    System.out.println("Not enough funds");
                }
                else {
                    customers.get(customerID-1).getAccounts().get(accountID-1).setCurrentBalance(currentBalance-transactionAmount);
                    transaction.setPostTransbalance(currentBalance-transactionAmount);
                }
            }
            else {
                customers.get(customerID-1).getAccounts().get(accountID-1).setCurrentBalance(currentBalance+transactionAmount);
                transaction.setPostTransbalance(currentBalance-transactionAmount);
            }
            tmpTrans.add(transaction);//add new transaction to list of transactions 
            customers.get(customerID-1).getAccounts().get(accountID-1).setTransactions(tmpTrans);//replace existing list of transactions with new updated list of transactions
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds.");
        }
        return tmpTrans;
    
    }
    
}
