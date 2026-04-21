package com.learning.multithreading;

class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount) {
        if(balance > amount) {
            System.out.println(Thread.currentThread().getName()+ " is withdrawing "+amount);
            balance-=amount;
            System.out.println("New Balance: "+balance);
        } else {
            System.out.println("Insufficient funds for: "+Thread.currentThread().getName());
        }
    }
}

public class BankBranch {
    public static void main(String...args) {
        BankAccount account = new BankAccount();
        Thread t1 = new Thread(() -> account.withdraw(80), "Alice");
        Thread t2 = new Thread(() -> account.withdraw(80), "Bob");
        t1.start();
        t2.start();
    }
}
