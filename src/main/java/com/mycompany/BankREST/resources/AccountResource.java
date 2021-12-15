/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BankREST.resources;

import com.mycompany.BankREST.models.Account;
import com.mycompany.BankREST.models.Customer;
import com.mycompany.BankREST.services.AccountService;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("/customers/{customerID}/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {
    private AccountService accountService = new AccountService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Account> getAccountsJSON(@PathParam("customerID")int id) {
        System.out.println("/accounts param customerID is "+id);
        return accountService.getAllAccounts(id);
    }
    
    @GET
    @Path("/{accountID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccountJSON(@PathParam("customerID")int customerID, @PathParam("accountID")int accountID) {
        System.out.println("/accounts param customerID is "+customerID+" and accountID is "+accountID);
        return accountService.getAccountID(customerID, accountID);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Account> setAccount(@PathParam("customerID")int customerID, Account account) {
        return accountService.setAccount(customerID, account);
    }
    
    @DELETE    
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Account> deleteAccount(@PathParam("customerID")int customerID, @QueryParam("accountID")int accountID) {
        return accountService.deleteAccount(customerID, accountID);
    }
}
