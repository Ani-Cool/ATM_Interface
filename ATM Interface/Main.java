public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initialize with an initial balance
        ATMGui atmGui = new ATMGui(userAccount);
    }
}
