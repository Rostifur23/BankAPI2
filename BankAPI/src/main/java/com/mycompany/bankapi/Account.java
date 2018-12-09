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
public class Account {
    
    
    private int account_id;
    private int sort_code;
    private int account_num;
    private double balance;
    private String account_type;
    private int cust_id;

    public Account(int account_id, int sort_code, int account_num, double balance, String account_type, int cust_id) {
        this.account_id = account_id;
        this.sort_code = sort_code;
        this.account_num = account_num;
        this.balance = balance;
        this.account_type = account_type;
        this.cust_id = cust_id;
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

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }
    
    
    
    
}