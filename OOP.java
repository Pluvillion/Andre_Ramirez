//Base class: Bank Account

class BankAccount {
    private String accountHolderName;
    private double balance;

    //Constructor
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Encapsulation: Getter and Setter Methods
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    //Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    //Method for withdrawal of money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid amount or your balance is too low.");
        }
    }

    //Polymorphism: Method Overriding
    public void displayAccountDetails() {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

//Derived class: Savings Account
class SavingsAccount extends BankAccount {

    @SuppressWarnings("FieldMayBeFinal")
    private double interestRate;
    private double overdraftLimit;

    //Constructor
    public SavingsAccount(String accountHolderName, double initialBalance, double interestRate) {
        super(accountHolderName, initialBalance);
        this.interestRate = interestRate;
        this.overdraftLimit = 0;
    }

    //Method to calculate interest
    public void calculateInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest: " + interest);
    }

    //Overriding withdraw method to include overdraft limit
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            double newBalance = getBalance() - amount;
            if (newBalance < 0) {
                overdraftLimit += newBalance; // Reduce overdraft limit
            }
            super.deposit(-amount); // Adjust balance
        } else {
            System.out.println("Invalid withdrawal amount or overdraft limit exceeded.");
        }
    }

    //Overriding displayAccountDetails method
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

//Derived class: Current Account
class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    //Constructor
    public CurrentAccount(String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    //Overriding withdraw method to include overdraft limit
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            double newBalance = getBalance() - amount;
            if (newBalance < 0) {
                overdraftLimit += newBalance; // Reduce overdraft limit
            }
            super.deposit(-amount);
        } else {
            System.out.println("Invalid withdrawal amount or overdraft limit exceeded.");
        }
    }

    //Overriding displayAccountDetails method
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

//Main class
public class OOP {
    public static void main(String[] args) {
        //Create a SavingsAccount
        SavingsAccount savings = new SavingsAccount("Philip Strand", 1000, 5);
        savings.displayAccountDetails();
        savings.deposit(500);
        savings.calculateInterest();
        savings.withdraw(300);
        savings.displayAccountDetails();

        System.out.println();

        //Create a CurrentAccount
        CurrentAccount current = new CurrentAccount("Hoshimi Miyabi", 2000, 1000);
        current.displayAccountDetails();
        current.withdraw(2500);
        current.withdraw(500);
        current.displayAccountDetails();
        
    }
}