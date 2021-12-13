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
public class Customer {
    private int customerID;

    
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String userName;
    private String password;
    private ArrayList<Account> accounts = new ArrayList<Account>();

    public Customer() {
    }
    
    public Customer(int customerID, String firstName, String lastName, String address, String email, String userName, String password) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    
    public void setAccount(Account account) {
        this.accounts.add(account);
    }
    
    
}
