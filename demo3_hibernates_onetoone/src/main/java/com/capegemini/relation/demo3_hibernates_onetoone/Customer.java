package com.capegemini.relation.demo3_hibernates_onetoone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private long id;
   private String name;
   @OneToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="Account_id",unique = true)
   private Account account;
   public Customer() { 
	   
   }
   public Customer( String name, Account account) {
	super();
	
	this.name = name;
	this.account = account;
   }
   public long getId() {
	return id;
   }
   public void setId(long id) {
	this.id = id;
   }
   public String getName() {
	return name;
   }
   public void setName(String name) {
	this.name = name;
   }
   public Account getAccount() {
	return account;
   }
   public void setAccount(Account account) {
	this.account = account;
   }
   
   

}
