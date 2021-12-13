/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BankREST.resources;

import com.mycompany.BankREST.models.Customer;
import com.mycompany.BankREST.services.CustomerService;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tadija
 */
@Path("/customers")
public class CustomerResource {
    private CustomerService customerService = new CustomerService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Customer> getCustomersJSON() {
        return customerService.getAllCustomers();
    }
    
    @GET
    @Path("/{customerID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerJSON(@PathParam("customerID") int id) {
        return customerService.getCustomer(id);
    }
    
    @DELETE
    @Path("/{customerID}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Customer> deleteCustomerJSON(@PathParam("customerID") int id) {
        return customerService.deleteCustomer(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer addCustomer(Customer tmp) {
        return customerService.addCustomer(tmp);
    }
}
