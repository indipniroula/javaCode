package lectures.bankdeadlocks;

import java.util.ArrayList;
import java.util.List;

public class DeadlockBank {

    public static void main(String[] args) {
        Account antosAccount = new Account("Anto", 10000);
        Account allysAccount = new Account("Ally", 10000);

        System.out.println("Anto's initial balance:  " + antosAccount.getBalance());
        System.out.println("Allys's initial balance: " + allysAccount.getBalance());

        List<Transfer> transactions = new ArrayList<>();
        final int transferAmount = 100;
        for (int i = 0; i < 1000; i++) {
            Transfer toAlly = new Transfer(antosAccount, allysAccount, transferAmount);
            toAlly.start();
            Transfer toAnto = new Transfer(allysAccount, antosAccount, transferAmount);
            toAnto.start();

            transactions.add(toAlly);
            transactions.add(toAnto);
        }

        // Wait for all the transactions to be executed
        transactions.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
            }
        });

        System.out.println("Anto's final balance:  " + antosAccount.getBalance());
        System.out.println("Allys's final balance: " + allysAccount.getBalance());
    }

    static class Transfer extends Thread {

        Account accountFrom;
        Account accountTo;
        int amount;

        public Transfer(Account accountFrom, Account accountTo, int amount) {
            this.accountFrom = accountFrom;
            this.accountTo = accountTo;
            this.amount = amount;
        }

        @Override
        public void run() {
            synchronized (accountFrom) {
                synchronized (accountTo) {
                    if (accountFrom.getBalance() >= amount) {
                        accountFrom.withdraw(amount);
                        accountTo.deposit(amount);
                        System.out
                                .println("transferred " + amount + " from " + accountFrom + " to " + accountTo);
                    }
                }
            }
        }
    }

    static class Account {

        String owner;
        int balance;

        public Account(String owner, int balance) {
            this.owner = owner;
            this.balance = balance;
        }

        void deposit(int amount) {
            balance = balance + amount;
        }

        void withdraw(int amount) {
            balance = balance - amount;
        }

        public int getBalance() {
            return balance;
        }

        @Override
        public String toString() {
            return "A[" + owner + "]";
        }
    }
}

