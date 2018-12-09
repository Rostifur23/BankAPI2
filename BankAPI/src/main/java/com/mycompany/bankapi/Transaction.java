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
public class Transaction {
    
    private int trans_id;
    private String trans_date;
    private String trans_desc;
    private double new_balance;
    private String trans_type;
    private int trans_to;
    private int account_id;

    public Transaction(int trans_id, String trans_date, String trans_desc, double new_balance, String trans_type, int trans_to, int account_id) {
        this.trans_id = trans_id;
        this.trans_date = trans_date;
        this.trans_desc = trans_desc;
        this.new_balance = new_balance;
        this.trans_type = trans_type;
        this.trans_to = trans_to;
        this.account_id = account_id;
    }

    public int getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(int trans_id) {
        this.trans_id = trans_id;
    }

    public String getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(String trans_date) {
        this.trans_date = trans_date;
    }

    public String getTrans_desc() {
        return trans_desc;
    }

    public void setTrans_desc(String trans_desc) {
        this.trans_desc = trans_desc;
    }

    public double getNew_balance() {
        return new_balance;
    }

    public void setNew_balance(double new_balance) {
        this.new_balance = new_balance;
    }

    public String getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type;
    }

    public int getTrans_to() {
        return trans_to;
    }

    public void setTrans_to(int trans_to) {
        this.trans_to = trans_to;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
    
}