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
            currentBalance = customers.get(customerID-1).getAccounts().get(accountID-1).getCurrentBalance();
            transactionAmount = transaction.getAmount();
            if (transaction.isWithdrawal()) {
                if (currentBalance-transactionAmount<0) {
                    System.out.println("Not enough funds");
                }
                else {
                    customers.get(customerID-1).getAccounts().get(accountID-1).setCurrentBalance(currentBalance-transactionAmount);
                    transaction.setPostTransbalance(currentBalance-transactionAmount);
                    tmpTrans.add(transaction);//add new transaction to list of transactions 
                    customers.get(customerID-1).getAccounts().get(accountID-1).setTransactions(tmpTrans);//replace existing list of transactions with new updated list of transactions
                }
            }
            else {
                customers.get(customerID-1).getAccounts().get(accountID-1).setCurrentBalance(currentBalance+transactionAmount);
                transaction.setPostTransbalance(currentBalance+transactionAmount);
                tmpTrans.add(transaction);//add new transaction to list of transactions 
                customers.get(customerID-1).getAccounts().get(accountID-1).setTransactions(tmpTrans);//replace existing list of transactions with new updated list of transactions
            }
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds.");
        }
        return tmpTrans;
    
    }
    
    public ArrayList<Transaction> setTransaction(int senderID, int senderaccountID, int receiverID, int receiveraccountID, Transaction senderTransaction) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date(); 
        senderTransaction.setCreated(date);
        Transaction receiverTransaction = senderTransaction;
        receiverTransaction.setWithdrawal(false);
        senderTransaction.setWithdrawal(true);
        double currentBalance=0, receivercurrentBalance = 0, transactionAmount = 0;
        ArrayList<Transaction> senderTrans = null;
        ArrayList<Transaction> receiverTrans = null;
        
        try {
            senderTrans = customers.get(senderID-1).getAccounts().get(senderaccountID-1).getTransactions(); // get list of transactions for senderID
            senderTransaction.setTransactionID(senderTrans.size()+1);        
            currentBalance = customers.get(senderID-1).getAccounts().get(senderaccountID-1).getCurrentBalance();
            receivercurrentBalance = customers.get(receiverID).getAccounts().get(receiveraccountID).getCurrentBalance();
            transactionAmount = senderTransaction.getAmount();
            //sender data
            
            //receiver data
            receiverTrans = customers.get(receiverID-1).getAccounts().get(receiveraccountID-1).getTransactions(); // get list of transactions for receiverID
            receiverTransaction.setTransactionID(receiverTrans.size()+1);  
            //end of receiver data
            if (currentBalance-transactionAmount<0) {
                System.out.println("Not enough funds");
            }
            else {
                customers.get(senderID-1).getAccounts().get(senderaccountID).setCurrentBalance(currentBalance-transactionAmount);
                senderTransaction.setPostTransbalance(currentBalance-transactionAmount);
                senderTrans.add(senderTransaction);
                customers.get(senderID-1).getAccounts().get(senderaccountID-1).setTransactions(senderTrans);//replace existing list of transactions with new updated list of transactions
                //end of sender 
                
                customers.get(receiverID-1).getAccounts().get(receiveraccountID-1).setCurrentBalance(receivercurrentBalance+transactionAmount);
                receiverTransaction.setPostTransbalance(receivercurrentBalance+transactionAmount);
                receiverTrans.add(receiverTransaction);
                customers.get(receiverID-1).getAccounts().get(receiveraccountID-1).setTransactions(receiverTrans);
                //end of receiver
                
            }
            
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds.");
        }
        return senderTrans;
    
    }
    
}
