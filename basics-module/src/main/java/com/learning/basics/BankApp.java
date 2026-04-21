package com.learning.basics;

class Account {
    int bal;
    String accountType;
    Account(int b, String accountType) {
        bal = b;
        this.accountType = accountType;
    }
}
class Loan {
    int loamAmount;
    Loan(int amt) {
        loamAmount = amt;
    }
}

class Customer {
    String firstName;
    String lastName;
    Account account;
    Loan loan;
    Customer(String firstName, String lastName, Account account, Loan loan) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.loan = loan;
    }
}
