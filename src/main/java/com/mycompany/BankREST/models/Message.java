/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BankREST.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
    private String message;
    private Date created;
    private String author;
    private int id;
    private List<Comment> comments = new ArrayList<>();

    
    public Message() {
    }

    public Message(int id, String message, String author, List<Comment> comments) {
        this.id = id;
        this.message = message;
        this.created = new Date();
        this.author = author;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String printMessage() {
        String str = this.getId()+" "+this.getAuthor()+ " "+this.getMessage();
        return str;
    }
    
    public String printAllComments() {
         String allcom = "";
         for ( int i=0; i<comments.size(); i++)
             allcom=allcom+comments.get(i).printComment()+" ";
	return allcom;
    }
    
    public List<Comment> getComments() {
	return comments;
    }

    public void setComments(List<Comment> comments) {
	this.comments = comments;
    }

     public void addCommentToMsg(Comment comment) {
	(this.comments).add(comment);
    }



}
