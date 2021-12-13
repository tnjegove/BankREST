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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tadija
 */
@Path("/customers/{customerID}/accounts")
public class AccountResource {
    private AccountService accountService = new AccountService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Account> getAccountsJSON(@PathParam("customerID")int id) {
        return accountService.getAllAccounts(id);
    }
}
