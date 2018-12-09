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
    
    BankResource res = new BankResource();
    Gson gson = new Gson();
    
    // Entry Point 1: Account Selection
    @GET
    @Path("/accounts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankAccounts() {
        
        ArrayList<Account> accounts = res.getBankAccounts();
        
        return Response.status(200).entity(gson.toJson(accounts)).build();
        
    }
    
    // Entry Point 2: User - Create Account
    @POST
    @Path("/user/account")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void createUserAccount(@FormParam("name") String name, @FormParam("email") String email, @FormParam("password") String password, @FormParam("con_password") String confirmPassword, @FormParam("address") String address){
        
        res.createUserAccount(name, email, password, address);
        
    }
    
    // Entry Point 3: User - Delete Account
    @DELETE
    @Path("/user/account")
    public void deleteUserAccount() {
        
        // use userSession
    }
    
    // Entry Point 4: User - Account Details
    @GET
    @Path("/user/account")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserDetails() {
        
        Customer cust = new Customer(1, "name", "address", "ross@email.com", "password");
        
        return Response.status(200).entity(gson.toJson(cust)).build();
        
    }
    
    // Entry Point 5: User - Edit Account (Password)
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/user/account/password")
    public void updatePassword(@FormParam("password") String password, @FormParam("con_password") String confirmPassword, @FormParam("new_password") String newPassword) {
        System.out.println(password);
        System.out.println(confirmPassword);
        System.out.println(newPassword);
    }
    
    // Entry Point 6: User - Edit Account (Address)
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/user/account/address")
    public void updateAddress(@FormParam("address") String address) {
        System.out.println(address);
    }
    
    // Entry Point 7: Account - Transaction (History)
    @GET
    @Path("/account/transactions")
    public Response getAccountTransactions() {
        // use account id
        ArrayList transactions = new ArrayList();
        return Response.status(200).entity(gson.toJson(transactions)).build();
        
    }
    
    // Entry Point 8: Transaction (Lodgement)
    @POST
    @Path("/account/transactions/lodgment")
    @Consumes(MediaType.APPLICATION_JSON)
    public void accountLodgment(String lodgment){
        
        System.out.println(lodgment);
        
    }
    
    // Entry Point 9: Transaction (Withdrawal)
    @POST
    @Path("/account/transactions/withdraw")
    @Consumes(MediaType.APPLICATION_JSON)
    public void accountWithdrawal(String withdrawal){
        
        System.out.println(withdrawal);
        
    }
    
    // Entry Point 10: Transaction (Transfer)
    @POST
    @Path("/account/transactions/transfer")
    @Consumes(MediaType.APPLICATION_JSON)
    public void accountTransfer(String transfer){
        
        System.out.println(transfer);
        
    }
    
    // Entry Point 11: User - Log In
    @POST
    @Path("/user/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void userLogIn(@FormParam("email") String email, @FormParam("password") String password){
        
        res.userLogIn(email, password);
        
    }
    
    // Entry Point 12: User - Log Out
    @DELETE
    @Path("/user/logout")
    public void userLogOut(){
        
        res.logOut();
        
    }
    
    // Entry Point 13: Bank - Create Account
    @POST
    @Path("/bank/account")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBankAccount(String bankAccountDetails){
        
        JsonElement jelement = new JsonParser().parse(bankAccountDetails);
        JsonObject  jobject = jelement.getAsJsonObject();
        String account_type = jobject.get("account_type").getAsString();
        System.out.println(account_type);
        
    }
    
    // Entry Point 14: Bank - Account Details
    @GET
    @Path("/bank/account")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankAccountDetails() {
        
        // use activeAccount
        
        return Response.status(200).entity(gson.toJson("put account here")).build();
        
    }
    
    
    // Entry Point 15: User - Get Session
    @GET
    @Path("/user/session")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSession() {
        int userSession = res.getSessionId();
        return Response.status(200).entity(gson.toJson(userSession)).build();
        
    }
    
}
