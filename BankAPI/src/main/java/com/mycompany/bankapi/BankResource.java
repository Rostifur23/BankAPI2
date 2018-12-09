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
    private int sessionId = 0;
    private int activeAccount = 0;
    private ArrayList<Customer> custArrayList;
    private ArrayList<Account> accArrayList;
    private ArrayList<Transaction> transArrayList;
    
    public ArrayList getBankAccounts(int uid){
        
        // get all account associated to the uid and return
        ArrayList accounts = new ArrayList<Account>();
        Customer cust = new Customer();
        
        accounts = cust.getAccounts();
        return accounts;
        
    }
    
    public void createUserAccount(String name, String email, String password, String address){
        // create new user account in DB
        int id = custArrayList.size();
        
        Customer cust = new Customer(id, name, email, password, address);
        
        custArrayList.add(cust);
        
    }
    
    public void deleteUser(){
        // delete user from database here
        
        for (Customer c : custArrayList) {
            if(c.getCustomer_id() == sessionId){
                custArrayList.remove(c);
            }
            else{
                System.out.println("No account available");
            }
        }
    }
    
    public Customer getUserDetails(){
        Customer cust = new Customer();
        
        for (Customer c : custArrayList){
            if(c.getCustomer_id() == sessionId){
                return c;
            }
        }
        return cust;
    }
    
    public void updatePassword(String password, String confirmPassword, String newPassword){
        // update users password in DB
        if(password.equals(confirmPassword)){
            for(Customer c : custArrayList){
                if(c.getCustomer_id() == sessionId){
                    c.setPassword(newPassword);
                }
            }
        }
        
    }
    
    public void updateAddress(String address, String newAddress){
        // update users address in DB
        for (Customer c : custArrayList){
            if(c.getCustomer_id() == sessionId){
                c.setCustomerAdr(newAddress);
            }
        }
    }
    
    public ArrayList getTransactions(){
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        
        for(Transaction t : transArrayList){
            if(t.getAccount_id() == activeAccount){
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
    
    public int userLogIn(){
        // update neccessary tables and store lodgment 
        int uid = 0;
        return uid;
    }
    
    public void createBankAccount(String account_type){
        // create new bank account in the DB 
        
        //Random number generation
        Random rand = new Random();
        
        int sort_code = rand.nextInt(999999999) + 1;
        int account_num = rand.nextInt(999999999) + 1;
        double balance = 0.0;
        int id = accArrayList.size();
        
        Account acc = new Account(id, sort_code, account_num, balance, account_type);
        accArrayList.add(acc);
    }
    
    public void deleteBankAccount(){
        // delete a specified bank account in the DB 
    }
    
    public Account getAccountDetails(int accountId){
        Account acc = new Account();
        
        for (Account a : accArrayList){
            if(a.getAccount_id() == sessionId){
                return a;
            }
        }
        return acc;
    }
    
    public void setSessionId(int sessionId){
        this.sessionId = sessionId;
    }
    
    public int getSessionId(){
        return sessionId;
    }
    
}
