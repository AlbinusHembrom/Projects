import java.util.Scanner;

class AhAccountData {
    // Private variables (Encapsulation)
    private String ahAccountNumber;
    private double ahBalance;

    // Shared static variable
    static String ahBankName = "National Bank";

    // Getter and Setter for Account Number
    public String getAhAccountNumber() {
        return ahAccountNumber;
    }

    public void setAhAccountNumber(String ahAccountNumber) {
        this.ahAccountNumber = ahAccountNumber;
    }

    // Getter and Setter for Balance
    public double getAhBalance() {
        return ahBalance;
    }

    public void setAhBalance(double ahBalance) {
        this.ahBalance = ahBalance;
    }

    // Method to display information
    void ahDisplayInfo() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Bank Name      : " + ahBankName);
        System.out.println("Account Number : " + this.ahAccountNumber);
        System.out.println("Balance        : ₹" + this.ahBalance);
    }
}

public class AHBankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AhAccountData ahAcc = new AhAccountData();

        // Taking input from the user
        System.out.print("Enter Account Number: ");
        ahAcc.setAhAccountNumber(sc.nextLine());

        System.out.print("Enter Initial Balance: ");
        ahAcc.setAhBalance(sc.nextDouble());

        // Displaying the output
        ahAcc.ahDisplayInfo();

        sc.close();
    }
}