/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BankREST.services;

import com.mycompany.BankREST.models.Comment;
import com.mycompany.BankREST.models.Message;
import java.util.ArrayList;
import java.util.List;

public class MessageService {
    public static List<Message> list = new ArrayList<>();
    public static boolean init = true;
    public static List<Comment> commentslist = new ArrayList<>();
    
    public MessageService() {
   if (init) {
       
       Comment c1 = new Comment (1,"One comment");  
       Comment c2 = new Comment (2,"Another comment");
       Comment c3 = new Comment (3,"And another comment more");
        
        commentslist.add(c1);
        commentslist.add(c2);
        commentslist.add(c3);

        Message m1 = new Message(1,"First", "Manuel", commentslist);
        Message m2 = new Message(2,"Second", "Jack", commentslist);        
        Message m3 = new Message(3,"Third", "Emer", commentslist);
        Message m4 = new Message(4,"First", "Lisa", commentslist);
        Message m5 = new Message(5,"Fifth", "Jack", commentslist);
        Message m6 = new Message(6,"Third", "Margarete", commentslist);
       
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
        list.add(m6);
        System.out.println("temp messages added");
        init = false;
       }
    }
 
        
    public List<Message> getAllMessages() {
        return list;
    }
    
    public Message getMessage(int id) {
        return list.get(id-1);
    }
    
    public List<Message> deleteMessage(int id) {
        list.remove(id-1);
        return list;
    }
    
    public Message createMessage(Message m) {
	m.setId(list.size() + 1);
	list.add(m);
	System.out.println("201 - resource created with path: /messages/" + String.valueOf(m.getId()));
        System.out.println("Updated Message:"+m.printMessage());
	return m;
    }

}
