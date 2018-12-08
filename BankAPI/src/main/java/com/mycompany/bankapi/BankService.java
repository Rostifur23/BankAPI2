/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Rostifur
 */
@Path("/bankapp")
public class BankService {
    
    private int userSession = 0;
    BankResource res = new BankResource();
    Gson gson = new Gson();
    
    // Entry Point 1: Account Selection
    @GET
    @Path("accounts/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankAccounts(@PathParam("uid") 
            String uid) {
        
        Account a1 = new Account(1234, 12345678, 123.47, "Current", 1, 1);
        Account a2 = new Account(5678, 87654321, 4150.34, "Savings", 1, 1);
        
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(a1);
        accounts.add(a2);
        
        String output = "This entry point will return all bank accounts for the user: " + uid;
        return Response.status(200).entity(gson.toJson(accounts)).build();
        
    }
    
    // Entry Point 2: User - Create Account
    @POST
    @Path("/user/account")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void createUserAccount(@FormParam("name") String name, @FormParam("email") String email, @FormParam("password") String password, @FormParam("con_password") String confirmPassword, @FormParam("address") String address){
        
        System.out.println(name);
        System.out.println(email);
        System.out.println(password);
        System.out.println(confirmPassword);
        System.out.println(address);
        
    }
    
    // Entry Point 3: User - Delete Account
    @DELETE
    @Path("/user/account/{uid}")
    public void deleteUserAccount(@PathParam("uid") 
            String uid) {
        int id = Integer.parseInt(uid);
        System.out.println(uid);
    }
    
    // Entry Point 4: User - Account Details
    @GET
    @Path("user/account/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserDetails(@PathParam("uid") 
            String uid) {
        
        int id = Integer.parseInt(uid);
        
        Customer cust = new Customer(id, "name", "address", "ross@email.com", "password");
        
        String output = "This entry point will return the account details for the user: " + uid;
        return Response.status(200).entity(gson.toJson(cust)).build();
        
    }
    
    // Entry Point 5: User - Edit Account (Password)
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("user/account/password")
    public void updatePassword(@FormParam("password") String password, @FormParam("con_password") String confirmPassword, @FormParam("new_password") String newPassword) {
        System.out.println(password);
        System.out.println(confirmPassword);
        System.out.println(newPassword);
    }
    
    // Entry Point 6: User - Edit Account (Address)
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("user/account/address")
    public void updateAddress(@FormParam("address") String address) {
        System.out.println(address);
    }
    
    // Entry Point 7: Account - Transaction (History)
    @GET
    @Path("account/transactions/{account_id}")
    public Response getAccountTransactions(@PathParam("account_id") 
            String accountId) {
        
        String output = "This entry point will return all transactions related to the account: " + accountId;
        return Response.status(200).entity(output).build();
        
    }
    
    // Entry Point 8: Transaction (Lodgement)
    @POST
    @Path("account/transactions/lodgment")
    @Consumes(MediaType.APPLICATION_JSON)
    public void accountLodgment(String lodgment){
        
        System.out.println(lodgment);
        
    }
    
    // Entry Point 9: Transaction (Withdrawal)
    @POST
    @Path("account/transactions/withdraw")
    @Consumes(MediaType.APPLICATION_JSON)
    public void accountWithdrawal(String withdrawal){
        
        System.out.println(withdrawal);
        
    }
    
    // Entry Point 10: Transaction (Transfer)
    @POST
    @Path("account/transactions/transfer")
    @Consumes(MediaType.APPLICATION_JSON)
    public void accountTransfer(String transfer){
        
        System.out.println(transfer);
        
    }
    
    // Entry Point 11: User - Log In
    @POST
    @Path("user/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void userLogIn(@FormParam("email") String email, @FormParam("password") String password){
        
        // set the userSession Variable here
        System.out.println(email);
        System.out.println(password);
        
        userSession = 1; // change to the id retrieved from the db search
        
    }
    
    @GET
    @Path("user/session")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSession() {
        
        return Response.status(200).entity(gson.toJson(userSession)).build();
        
    }
    
    // Entry Point 12: User - Log Out
    @POST
    @Path("user/logout")
    @Consumes(MediaType.APPLICATION_JSON)
    public void userLogOut(String uid){
        
        System.out.println(uid);
        
    }
    
    // Entry Point 13: Bank - Create Account
    @POST
    @Path("bank/account")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBankAccount(String bankAccountDetails){
        
        System.out.println(bankAccountDetails);
        
    }
    
    // Entry Point 14: Bank - Delete Account
    @DELETE
    @Path("bank/account/{account_id}")
    public void deleteBankAccunt(@PathParam("account_id") 
            String accountId) {
        int id = Integer.parseInt(accountId);
        System.out.println(id);
    }
    
    // Entry Point 15: Bank - Account Details
    @GET
    @Path("bank/account/{account_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankAccountDetails(@PathParam("account_id") 
            String accountId) {
        
        int id = Integer.parseInt(accountId);
        Account a1 = new Account(1234, 12345678, 123.47, "Current", id, 1);
        return Response.status(200).entity(gson.toJson(a1)).build();
        
    } 
    
}
