/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BankREST.services;

import com.mycompany.BankREST.models.Message;
import java.util.ArrayList;
import java.util.List;

public class MessageService {
    public static List<Message> list = new ArrayList<>();
    public static boolean init = true;
    
    public MessageService() {
   if (init) {
        Message m1 = new Message(1,"First", "Manuel");
        Message m2 = new Message(2,"Second", "Jack");        
        Message m3 = new Message(3,"Third", "Emer");
        Message m4 = new Message(4,"First", "Lisa");
        Message m5 = new Message(5,"Fifth", "Jack");
        Message m6 = new Message(6,"Third", "Margarete");
       
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
        list.add(m6);
        init = false;
       }
    }
 
        
    public List<Message> getAllMessages() {
        return list;
    }
    
     public Message getMessage(int id) {
        return list.get(id-1);
    }  
}