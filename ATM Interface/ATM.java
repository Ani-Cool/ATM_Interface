import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayOptions() {
        System.out.println("Welcome to the ATM. Please choose an option:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
    }

    public void performTransaction() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        do {
            displayOptions();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    double balance = account.getBalance();
                    System.out.println("Your balance is: $" + balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    amount = scanner.nextDouble();
                    if (account.withdraw(amount)) {
                        System.out.println("Withdrawal successful.");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);
    }
}
