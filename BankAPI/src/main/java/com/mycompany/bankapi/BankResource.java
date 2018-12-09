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
    
    public void makeLodgment(String trans_date, String desc, Double amount){
        // update neccessary tables and store lodgment 
        double account_bal;
        int trans_to = 0;
        String trans_type = "Lodgment";
        int id = transArrayList.size()+1;
        Transaction trans;
        
        for(Account a : accArrayList){
            if(a.getAccount_id() == getActiveAccount()){
                account_bal = a.getBalance();
                account_bal = account_bal + amount;
                a.setBalance(account_bal);
                
                trans = new Transaction(id, trans_date, desc, account_bal, trans_type, trans_to, getActiveAccount());
                transArrayList.add(trans);
            }
        }
    }
    
    public void makeWithdrawal(String trans_data, String desc, Double amount){
        // update neccessary tables and store withdrawal 
        double account_bal;
        int trans_to = 0;
        String trans_type = "Withdrawal";
        int id = transArrayList.size()+1;
        Transaction trans;
        
        for(Account a : accArrayList){
            if(a.getAccount_id() == getActiveAccount()){
                account_bal = a.getBalance();
                account_bal = account_bal - amount;
                a.setBalance(account_bal);
                
                trans = new Transaction(id, trans_data, desc, account_bal, trans_type, trans_to, getActiveAccount());
                transArrayList.add(trans);
            }
        }
    }
    
    public void makeTransfer(String trans_data, String desc, Double amount, Integer trans_to){
        // update neccessary tables and store transfer 
        double account_bal;
        String trans_type = "Transfer";
        int id = transArrayList.size()+1;
        Transaction trans;
        
          //get bank account, balance
          for(Account a : accArrayList){
            if(a.getAccount_id() == getActiveAccount()){
                account_bal = a.getBalance();
                
                //check transfer is possible
                account_bal = account_bal - amount;
                
                if(account_bal >= 0){
                    a.setBalance(account_bal);

                    for(Account b : accArrayList){
                        if(b.getAccount_num() == trans_to){
                                account_bal = b.getBalance();
                                account_bal = account_bal + amount;
                                b.setBalance(account_bal);

                                trans = new Transaction(id, trans_data, desc, account_bal, trans_type, trans_to, getActiveAccount());
                                transArrayList.add(trans);
                        }

                        else{
                            System.out.print("Transaction failed!");
                        }

                    }
                }
                
                else{
                    System.out.print("Insufficient balance!");
                }
          }
        
        }
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
        
        Account a = new Account(id, sort_code, account_num, balance, account_type, getSessionId());
        accArrayList.add(a);
        
    }
    
    public Account getAccountDetails(){
        
        for (Account a : accArrayList){
            if(a.getAccount_id() == getActiveAccount()){
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