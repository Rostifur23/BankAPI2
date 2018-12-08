/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author Aaron
 */
@Entity
@Table
@XmlRootElement
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customer_id;
    
    private String name;
    private String customer_adr;
    private String email;
    private String password;
      
    public Customer(int customer_id, String name, String customer_adr, String email, String password){
        super();
        this.customer_id = customer_id;
        this.name = name;
        this.customer_adr = customer_adr;
        this.email = email;
        this.password = password;
    }
    
    public Customer(){
        accounts = new ArrayList<>();
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerAdr() {
        return customer_adr;
    }

    public void setCustomerAdr(String customer_adr) {
        this.customer_adr = customer_adr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @OneToMany(targetEntity=Account.class, cascade = CascadeType.ALL, mappedBy="cust")
    private List<Account> accounts;
    
    public void setAccounts(List<Account> accountlist){
        this.accounts = accountlist;
    }
    
    @XmlElementWrapper(name="account")
    @XmlElementRef()
    public List<Account> getAccounts(){
        return accounts;
    }
    
    public static void main(String[] args){
        
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistance_connect");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
                
        Account acc = new Account();

        entitymanager.persist(acc);

        Customer cust1 = new Customer(1, "name", "address", "email@email", "password");

        acc.setCustomer(cust1);

        // entitymanager.persist(trans1);
        ArrayList<Account> accounts = new ArrayList<>();
        
        accounts.add(acc);
        
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close(); 
    }
        
}
