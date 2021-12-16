/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BankREST.resources;

import com.mycompany.BankREST.models.Transaction;
import com.mycompany.BankREST.services.TransactionService;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tadija
 */
@Path("/customers/{customerID}/accounts/{accountID}/transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {
    private TransactionService transactionService = new TransactionService();
    
    @GET
    public ArrayList<Transaction> getTransactions(@PathParam("customerID")int customerID, @PathParam("accountID")int accountID) {
        return transactionService.getAllTransactions(customerID, accountID);
    }
    
    @GET
    @Path("/{transactionID}")
    public Transaction getTransactionID(@PathParam("customerID")int customerID, @PathParam("accountID")int accountID, @PathParam("transactionID")int transactionID) {
        return transactionService.getTransaction(customerID, accountID, transactionID);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Transaction> setTransaction(@PathParam("customerID")int customerID, @PathParam("accountID")int accountID, Transaction transaction) {
        return transactionService.setTransaction(customerID, accountID, transaction);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Transaction> setTransaction(@PathParam("senderID")int senderID, @PathParam("senderaccountID")int senderaccountID, @QueryParam("receiverID")int receiverID, @QueryParam("receiveraccountID")int receiveraccountID, Transaction transaction ) {
        return transactionService.setTransaction(senderID, senderaccountID, receiverID, receiveraccountID, transaction);
    }
}
