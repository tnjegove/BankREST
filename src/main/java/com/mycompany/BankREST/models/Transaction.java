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
    private double postTransbalance;
    private Date created;
    private String description;

    public double getBalance() {
        return postTransbalance;
    }

    public void setBalance(double balance) {
        this.postTransbalance = balance;
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
    
    
    
}
