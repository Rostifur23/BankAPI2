/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aaron
 */
@Entity
@Table
@XmlRootElement
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int account_id;
    
    private int sort_code;
    private int account_num;
    private double balance;
    private String account_type;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer cust;
    

    public Account(int account_id, int sort_code, int account_num, double balance, String account_type) {
        this.account_id =  account_id;
        this.sort_code = sort_code;
        this.account_num = account_num;
        this.balance = balance;
        this.account_type = account_type;
    }
    
    public Account(){
        transaction = new ArrayList<>();
    }
    
    @OneToMany(targetEntity = Transaction.class, cascade = CascadeType.MERGE, mappedBy="acc")
    private List<Transaction> transaction;
    
    public void setTransactions(List<Transaction> transactionlist){
        this.transaction = transactionlist;
    }
    
    @XmlElementWrapper(name="transaction")
    @XmlElementRef()
    public List<Transaction> getTransaction(){
        return transaction;
    }

    public Customer getCustomer() {
        return cust;
    }

    public void setCustomer(Customer cust) {
        this.cust = cust;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getSort_code() {
        return sort_code;
    }

    public void setSort_code(int sort_code) {
        this.sort_code = sort_code;
    }

    public int getAccount_num() {
        return account_num;
    }

    public void setAccount_num(int account_num) {
        this.account_num = account_num;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }
    
    public static void main(String [] args){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistance_connect");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        
        Account acco = new Account();
        
        //entitymanager.persist(acco);
        
        Customer cust2 = new Customer(1, "name", "address", "email@email", "password");
        
        acco.setCustomer(cust2);
        
        List<Account> customers = new ArrayList<>();
        
        customers.add(acco);
        
        cust2.setAccounts(customers);
        
        entitymanager.persist(cust2);
        
        
        
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }
    
    
}
