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
        ArrayList<Transaction> tmpTrans = null;
        ArrayList<Account> tmpAccounts;
        tmpAccounts = (ArrayList<Account>)customers.get(customerID).getAccounts();
        //find an account with id accountID in arraylist of accounts
        
        for (int i=0; i<tmpAccounts.size();i++) {
            if (tmpAccounts.get(i).getAccountID()==accountID) {
                tmpTrans = tmpAccounts.get(i).getTransactions();
                break;
            }
            
        }
        return tmpTrans;
    }
    
}
