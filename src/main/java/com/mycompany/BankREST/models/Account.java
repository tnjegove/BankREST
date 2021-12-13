/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BankREST.models;

import java.util.ArrayList;

/**
 *
 * @author tadija
 */
public class Account {
    private int accountID;
    private String sortCode;
    private String accNumber;
    private double currentBalance;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    public Account(int accountID, String sortCode, String accNumber, double currentBalance) {
        this.accountID = accountID;
        this.sortCode = sortCode;
        this.accNumber = accNumber;
        this.currentBalance = currentBalance;
    }
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    public void setTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
    
    
}
