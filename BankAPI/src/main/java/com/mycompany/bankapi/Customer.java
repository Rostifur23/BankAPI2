/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aaron
 */

@XmlRootElement
public class Customer {
    
    private int customer_id;
    private String name;
    private String address;
    private String email;
    private String password;

    public Customer(int customer_id, String name, String address, String email, String password) {
        this.customer_id = customer_id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    
    
      
        
}