package com.driver;

public class BankAccount {

    private String name;
    private double balance;

    public BankAccount() {
    }

    private double minBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        if(sum > digits*9){
            throw new Exception("Account number cannot be genreated");
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0;i<digits;i++){
            if(sum>=9){
                s.append('9');
                sum -= 9;
            }
            else {
                s.append((char) ('0'+sum));
            }
        }

        return s.toString();
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance-amount<this.minBalance){
            throw new Exception("Insufficient Balance");
        }
        this.balance -= amount;
    }

}