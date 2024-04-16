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

    public Account(String name, double balance, String type) {
        this.name = name;
        this.iban =   startedIban++;;
        this.balance = balance;
        this.owedBalance=0;
        setType(type);
        numOfAccounts++;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }
    public void withdraw(double amount) {
        balance = balance - amount;
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
    public long getAccountNumber() {
        return accountNumber;
    }
    public void transfer(double amount, Account destination) {
        balance = balance - amount;
        destination.deposit(amount);
    }
    public void request(double amount, Account destination) {
        System.out.println("You requested " + amount + " " + getName());
    }
    public String toString() {
        return "Name: " + getName() + ", Iban: " + getIban() + ", Balance: " + balance;
    }
    public void declineRequest(){
        System.out.println("You declined the request");
    }
    public void acceptRequest(double amount){
        System.out.println("You accepted the request");
        balance = balance - amount;
        System.out.println("your balance now is: " + balance);
    }
    public void setType(String type) {
        convert(type);
    }
    public String getType() {
        return type.toString();
    }
    public void changeType(String newType) {
        convert(newType);
        return;
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

}
