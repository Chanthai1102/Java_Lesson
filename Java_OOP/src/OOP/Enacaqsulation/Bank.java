package OOP.Enacaqsulation;

import java.util.prefs.BackingStoreException;

public class Bank {
    private String BankName;
    private BankAccount[] bankAccounts ;

    public Bank(String bankName, BankAccount[] bankAccounts) {
        BankName = bankName;
        this.bankAccounts = bankAccounts;
    }
    private BankAccount getBankAccountByNumber(String accountNumber){
        for (BankAccount bankAccount : bankAccounts){
            if (bankAccount.getAccountNumber().equals(accountNumber)){
                return bankAccount;
            }
        }
        return null;
    }
    private boolean isEnoughBalance(BankAccount bankAccount, double amountTransfer){
        return bankAccount.getBalance() >= amountTransfer ;
    }
    private boolean isValidAmount(double amount){
        return amount > 0;
    }
    private void withdraw(BankAccount bankAccount, double amount){
        double newBalance = bankAccount.getBalance() - amount ;
        bankAccount.setBalance(newBalance);
    }
    private void deposti(BankAccount bankAccount, double amount){
        double newBalance = bankAccount.getBalance() + amount ;
        bankAccount.setBalance(newBalance);
    }
    private boolean checkUser(String name){
        for (BankAccount bankAccount : bankAccounts){
            if (bankAccount.getAccountNumber().equals(name)){
                return false;
            }
        }
        return true;
    }
    public void transfer(String accountSource, String accountTarget, double amount){
        BankAccount source = getBankAccountByNumber(accountSource);
        if (source == null){
            System.out.println("Invalid Account Number");
            return;
        }
        BankAccount target = getBankAccountByNumber(accountTarget);
        if (target == null){
            System.out.println("Invalid Account Number");
            return;
        }
        boolean isValidBalance = isEnoughBalance(source,amount);
        if (!isValidBalance){
            System.out.println("Your Account Balance is not enough");
            return;
        }
        if (!isValidAmount(amount)){
            System.out.println("Amount is Must be greater than 0");
            return;
        }
        withdraw(source,amount);
        deposti(target,amount);
    }
    public void display(){
        for (BankAccount bankAccount : bankAccounts){
            System.out.println(bankAccount.toString());
        }
    }
    public void openAccount(String name,double amount){
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountName().equals(name)) {
                System.out.println("An account with this name already exists.");
                return;
            }
        }
        BankAccount newAccount = new BankAccount(name, amount);

        // Create a new array to hold create new space for new account
        BankAccount[] tempAccounts = new BankAccount[bankAccounts.length + 1];

        // Copy accounts into the new array
        System.arraycopy(bankAccounts, 0, tempAccounts, 0, bankAccounts.length);

        // Add the new account to the end of the array
        tempAccounts[tempAccounts.length - 1] = newAccount;

        // Update the bankAccounts
        bankAccounts = tempAccounts;

        System.out.println("Account created successfully.");
    }
}
