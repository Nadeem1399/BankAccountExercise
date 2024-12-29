package bankaccountexercise;

import java.util.Scanner;

public class BankAccountExercise {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Variable to keep track of the account balance
        double balance = 0.0;

        // Start the loop for the program
        while (true) {
            System.out.print("Would you like to continue? (Y/N): ");
            String continueInput = scanner.nextLine().trim().toUpperCase();

            // Check if the user wants to continue
            if (continueInput.equals("Y")) {

                // Ask for the transaction type: Deposit, Withdrawal, or Balance
                System.out.print("What kind of transaction would you like to do? (D for Deposit, W for Withdrawal, B for Balance): ");
                String transactionType = scanner.nextLine().trim().toUpperCase();

                // Handle Deposit (D)
                if (transactionType.equals("D")) {
                    System.out.print("Enter the amount to deposit: ");
                    try {
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        if (depositAmount > 0) {
                            balance += depositAmount;
                            System.out.printf("Deposited: $%.2f. Current Balance: $%.2f%n", depositAmount, balance);
                        } else {
                            System.out.println("Deposit amount must be greater than zero.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number for the deposit.");
                    }

                }
                // Handle Withdrawal (W)
                else if (transactionType.equals("W")) {
                    if (balance == 0) {
                        System.out.println("No funds in the account. Please deposit first.");
                    } else {
                        System.out.print("Enter the amount to withdraw: ");
                        try {
                            double withdrawalAmount = Double.parseDouble(scanner.nextLine());
                            if (withdrawalAmount <= 0) {
                                System.out.println("Withdrawal amount must be greater than zero.");
                            } else if (withdrawalAmount > balance) {
                                System.out.printf("Insufficient funds! You only have $%.2f in your account.%n", balance);
                            } else {
                                balance -= withdrawalAmount;
                                System.out.printf("Withdrew: $%.2f. Current Balance: $%.2f%n", withdrawalAmount, balance);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number for the withdrawal.");
                        }
                    }

                }
                // Handle Balance (B)
                else if (transactionType.equals("B")) {
                    System.out.printf("Current Balance: $%.2f%n", balance);
                } else {
                    System.out.println("Invalid input. Please choose D, W, or B.");
                }

            }
            // If user wants to exit the program
            else if (continueInput.equals("N")) {
                System.out.printf("Thank you for using our service. Your final balance is: $%.2f%n", balance);
                break;
            } else {
                System.out.println("Invalid input. Please enter Y or N to continue.");
            }
        }

        // Close the scanner object to avoid memory leaks
        scanner.close();
    } 
}
