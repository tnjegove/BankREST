/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BankREST.models;

import java.util.Date;

/**
 *
 * @author tadija
 */
public class Transaction {
    private int transactionID;
    private double postTransbalance;
    private Date created;
    private String description;
    private boolean withdrawal;

    public Transaction(int transactionID, double postTransbalance, Date created, String description, boolean withdrawal) {
        this.transactionID = transactionID;
        this.postTransbalance = postTransbalance;
        this.created = created;
        this.description = description;
        this.withdrawal = withdrawal;
    }

    public Transaction() {
    }
    
    
    
    
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public double getPostTransbalance() {
        return postTransbalance;
    }

    public void setPostTransbalance(double postTransbalance) {
        this.postTransbalance = postTransbalance;
    }    

    
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(boolean withdrawal) {
        this.withdrawal = withdrawal;
    }
    
    
    
}
