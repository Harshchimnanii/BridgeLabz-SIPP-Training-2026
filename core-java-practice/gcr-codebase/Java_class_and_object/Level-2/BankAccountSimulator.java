
public class BankAccountSimulator {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public BankAccountSimulator(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccountSimulator account = new BankAccountSimulator("Ankit", "ACC12345", 5000.0);
        account.displayBalance();
        account.deposit(2000.0);
        account.withdraw(1500.0);
        account.displayBalance();
    }
}
