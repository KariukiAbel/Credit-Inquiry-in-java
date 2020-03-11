package com.nabesh;

public class AccountRecord {
    //Declaring all class variables and instances of other classes
    private int account;
    private String firstName;
    private String lastName;
    private  double balance;

    //Constructor (called when during building of the class)
    //no-arguement constructor calls other constructor with default values
    public AccountRecord(){
        this(0, "", "",0.0);
    }

    //initialize record
    public AccountRecord(int acct, String first, String last, double bal){
        setAccount(acct);
        setFirstName(first);
        setLastName(last);
        setBalance(bal);

    }
//Setters
    public void setAccount(int acct) {
        this.account = acct;
    }

    public void setFirstName(String first) {
        this.firstName = first;
    }

    public void setLastName(String last) {
        this.lastName = last;
    }

    public void setBalance(double bal) {
        this.balance = bal;
    }
    //Getters

    public int getAccount() {
        return account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }
}
