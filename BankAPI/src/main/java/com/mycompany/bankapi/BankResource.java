/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Rostifur
 */
public class BankResource {
    private static int sessionId = 0;
    private static int activeAccount = 0;
    private static ArrayList<Customer> custArrayList = new ArrayList<>();
    private static ArrayList<Account> accArrayList = new ArrayList<>();
    private static ArrayList<Transaction> transArrayList = new ArrayList<>();
    
    public ArrayList getBankAccounts(){
        
        ArrayList<Account> accounts = new ArrayList<>();
        
        for (Account a : accArrayList) {
            if(a.getCust_id() == getSessionId()){
                accounts.add(a);
            }
            else{
                System.out.println("No account found");
            }
        }
        
        return accounts;
    }
    
    public void createUserAccount(String name, String email, String password, String address){
        // create new user account in DB
        int id = custArrayList.size()+1;
        
        System.out.println(id);
        
        Customer cust = new Customer(id, name, address, email, password);
        custArrayList.add(cust);
        setSessionId(id);
        
        System.out.println(cust.getCustomer_id());
        System.out.println(cust.getName());
        
    }
    
    public void deleteUser(){
        // delete user from database here
        
        for (Customer c : custArrayList) {
            if(c.getCustomer_id() == getSessionId()){
                custArrayList.remove(c);
            }
            else{
                System.out.println("No user found");
            }
        }
    }
    
    public Customer getUserDetails(){
        
        for (Customer c : custArrayList){
            if(c.getCustomer_id() == getSessionId()){
                return c;
            }
        }
        
        return null;
        
    }
    
    public void updatePassword(String password, String confirmPassword, String newPassword){
        // update users password in DB
        if(password.equals(confirmPassword)){
            for(Customer c : custArrayList){
                if(c.getCustomer_id() == getSessionId()){
                    if(password.equals(c.getPassword())){
                        c.setPassword(newPassword);
                    }
                }
                
            }
        }
        
    }
    
    public void updateAddress(String newAddress){
        // update users address in DB
        for (Customer c : custArrayList){
            if(c.getCustomer_id() == getSessionId()){
                c.setAddress(newAddress);
            }
        }
    }
    
    public ArrayList getTransactions(){
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        
        for(Transaction t : transArrayList){
            if(t.getAccount_id() == getActiveAccount()){
                transactions.add(t);
            }
        }
        
        return transactions;
    }
    
    public void makeLodgment(String lodgment){
        // update neccessary tables and store lodgment 
        
    }
    
    public void makeWithdrawal(){
        // update neccessary tables and store withdrawal 
    }
    
    public void makeTransfer(){
        // update neccessary tables and store transfer 
    }
    
    public void userLogIn(String email, String password){
        for (Customer c : custArrayList){
            System.out.println(c.getEmail());
            System.out.println(c.getPassword());
            if((c.getEmail().equals(email) && (c.getPassword().equals(password)))){
                setSessionId(c.getCustomer_id());
            }
        }
    }
    
    public void createBankAccount(String account_type){
        // create new bank account in the DB 
        
        //Random number generation
        Random rand = new Random();
        
        int sort_code = rand.nextInt(999999999) + 1;
        int account_num = rand.nextInt(999999999) + 1;
        double balance = 0.0;
        int id = accArrayList.size()+1;
        
        Account acc = new Account(id, sort_code, account_num, balance, account_type, getSessionId());
        accArrayList.add(acc);
        
    }
    
    public Account getAccountDetails(){
        
        for (Account a : accArrayList){
            if(a.getAccount_id() == getSessionId()){
                return a;
            }
        }
        return null;
    }
    
    public void setSessionId(int sessionId){
        this.sessionId = sessionId;
    }
    
    public int getSessionId(){
        return sessionId;
    }
    
    public void setActiveAccount(int account_id){
        this.activeAccount = account_id;
    }
    
    public int getActiveAccount(){
        return activeAccount;
    }
    
    public void logOut(){
        this.sessionId = 0;
    }
    
}