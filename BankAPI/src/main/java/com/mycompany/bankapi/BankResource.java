/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi;

import java.util.ArrayList;


/**
 *
 * @author Rostifur
 */
public class BankResource {
    
    ArrayList<Account> accounts = new ArrayList();
    ArrayList<Customer> customers = new ArrayList();
    public int sessionId;
    private int activeAccount;

    public BankResource(int sessionId, int activeAccount) {
        this.sessionId = sessionId;
        this.activeAccount = activeAccount;
    }

    
    
    public ArrayList getBankAccounts(){
        
        
        Account a1 = new Account(1234, 12345678, 123.47, "Current", 1, 1);
        Account a2 = new Account(5678, 87654321, 4150.34, "Savings", 1, 1);
        
        // get all account associated to the uid and return
        
        accounts.add(a1);
        accounts.add(a2);
        return accounts;
        
    }
    
    public void createUserAccount(){
        // create new user account in DB
    }
    
    public void deleteUser(int uid){
        // delete user from database here
    }
    
    public ArrayList getUserDetails(int uid){
        ArrayList details = new ArrayList();
        return details;
    }
    
    public void updatePassword(){
        // update users password in DB
    }
    
    public void updateAddress(){
        // update users address in DB
    }
    
    public ArrayList getTransactions(int accountId){
        ArrayList transactions = new ArrayList();
        return transactions;
    }
    
    public void makeLodgment(){
        // update neccessary tables and store lodgment 
    }
    
    public void makeWithdrawal(){
        // update neccessary tables and store withdrawal 
    }
    
    public void makeTransfer(){
        // update neccessary tables and store transfer 
    }
    
    public int userLogIn(){
        // update neccessary tables and store lodgment 
        int uid = 0;
        return uid;
    }
    
    public void createBankAccount(){
        // create new bank account in the DB 
    }
    
    public void deleteBankAccount(){
        // delete a specified bank account in the DB 
    }
    
    public ArrayList getAccountDetails(int accountId){
        ArrayList accountDetails = new ArrayList();
        return accountDetails;
    }
    
    public void setSession(int id){
        this.sessionId = id;
    }
    
    public int getSession(){
        return this.sessionId;
    }
    
}
