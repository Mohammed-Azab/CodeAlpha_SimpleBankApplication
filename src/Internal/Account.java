package Internal;

import java.time.LocalDate;
import java.util.LinkedList;

public class Account {
    private double balance;
    private final String name;
    private final long iban;
    private long accountNumber;
    private accType type;
    private double interest;
    private double owedBalance;
    private static int numOfAccounts;
    private static int startedIban;
    private LinkedList<String> transactionHistory; // Change to Stack
    private currency c;
    private final LocalDate dateOfIssued;
    private LocalDate dateOfTransaction;

    public Account(String name, double balance, String type, String currency) {
        this.name = name;
        this.iban = startedIban++;
        this.balance = balance;
        this.owedBalance = 0;
        setType(type);

        numOfAccounts++;
        transactionHistory = new LinkedList<>(); // Initialize as Stack
        dateOfIssued = LocalDate.now();
        setCurrency(currency);
    }

    public LocalDate getDateOfIssued() {
        return dateOfIssued;
    }

    public  LinkedList<String> getTransactionHistory(){ // Change return type to Stack
        return transactionHistory;
    }

    public void printTransactionHistory(){
        System.out.println(transactionHistory);
    }

    public void deposit(double amount) {
        LocalDate currentDate = LocalDate.now();
        balance += amount;
        transactionHistory.add(amount + " deposited on " + currentDate); // Push to Stack
    }


    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public long getIban() {
        return iban;
    }

    public boolean transfer(double amount, Account destination) {
        if (amount > balance) {
            System.out.println("Transaction is not allowed due to low balance");
            return false;
        }

        LocalDate currentDate = LocalDate.now();
        balance -= amount;
        destination.deposit(amount);

        transactionHistory.add(amount + " transferred to " + destination.getName() + " on " + currentDate); // Push to Stack
        destination.getTransactionHistory().add(amount + " received from " + getName() + " on " + currentDate); // Push to Stack

        return true;
    }

    public void request(double amount, Account destination) {
        System.out.println("You requested " + amount + " " + getName());
    }

    public double getInterest() {
        return interest;
    }

    public String toString() {
        return "Name: " + getName() + ", Iban: " + getIban() + ", Balance: " + balance;
    }

    public void declineRequest(){
        System.out.println("You declined the request");
    }

    public void acceptRequest(double amount){
        System.out.println("You accepted the request");
        balance -= amount;
        System.out.println("Your balance now is: " + balance);
    }

    public void setType(String type) {
        convert(type);
    }

    public String getType() {
        return type.toString();
    }

    public void changeType(String newType) {
        convert(newType);
    }

    private void convert(String newType) {
        switch (newType) {
            case "debit":
                this.type= accType.debit; return;
            case "credit":
                this.type= accType.credit; return;
            case "prepaid":
                this.type= accType.prepaid; return;
            default: return;
        }
    }

    public String getCurrency() {
        return c.getFullName();
    }
    private void setCurrency(String currency) {
        switch (currency) {
            case "EUR":
                c = c.EUR; return;
            case "GBP":
                c = c.GBP; return;
            case "USD":
                c = c.USD; return;
            case "JPY":
                c = c.JPY; return;
            case "AUD":
                c = c.AUD; return;
            case "CHF":
                c = c.CHF; return;
            case "CNY":
                c = c.CNY; return;
            case "SEK":
                c = c.SEK; return;
            case "NZD":
                c = c.NZD; return;
            default:
                return;
        }
    }

    public void payCredit(double amount) {
        if (owedBalance==0){
            System.out.println("Your owed money is zero");
            return;
        }
        owedBalance -= amount;
        System.out.println("You have paid " + amount + " credit");
        transactionHistory.add(amount + "paid credit "+amount);
    }

    public boolean withdraw(double amount) {
        LocalDate currentDate = LocalDate.now();
        if (type != accType.credit && amount > balance){
            return false;
        }
        balance -= amount;
        if(balance < 0){
            owedBalance = balance;
            balance = 0;
        }
        transactionHistory.add(amount + " withdrawn on " + currentDate+ amount);
        return true;
    }
    public String getCurrencySymbol() {
        return c.getSymbol();
    }

}
