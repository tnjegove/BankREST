/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myblog.resources;

import com.mycompany.myblog.models.Message;
import com.mycompany.myblog.services.MessageService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;




@Path("/messages")

public class MessageResource {
    
    MessageService messageService = new MessageService();
    /*
    If using POSTMAN as client, remember setting a Header 
    "Accept:application/json" for retrieving JSON format
    "Accept:application/xml" for retrieving XML format
    */    
   
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessagesXML() {
        return messageService.getAllMessages();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessagesJSON() {
        return messageService.getAllMessages();
    }

          
 
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_XML)
    public Message getMessageXML(@PathParam("messageId") int id) {
        return messageService.getMessage(id);
    }
    
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessageJSON(@PathParam("messageId") int id) {
        return messageService.getMessage(id);
    }
} 
    
    