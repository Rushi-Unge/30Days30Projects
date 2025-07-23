
import java.util.Scanner;

public class MindReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int low = 1;
        int high = 100;
        int maxAttempts = 5;

        printBanner();

        System.out.println("\nINSTRUCTIONS:");
        System.out.println(" - Think of a number between 1 and 100.");
        System.out.println(" - I will try to guess it in " + maxAttempts + " attempts.");
        System.out.println(" - After each guess, respond with:");
        System.out.println("     > 'low'     (if your number is higher)");
        System.out.println("     > 'high'    (if your number is lower)");
        System.out.println("     > 'correct' (if I guessed it right)");
        printDivider();

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            int guess = low + (high - low) / 2;

            System.out.println("\n[ Attempt " + attempt + " of " + maxAttempts + " ]");
            System.out.println("Is your number: " + guess + "?");
            System.out.print("Your response (low/high/correct): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("correct")) {
                System.out.println("\n--------------------------------------------------");
                System.out.println(" SUCCESS! I guessed your number in " + attempt + " attempt(s).");
                System.out.println(" Thanks for playing the MindReader Game!");
                System.out.println("--------------------------------------------------");
                return;
            } else if (response.equals("low")) {
                low = guess + 1;
            } else if (response.equals("high")) {
                high = guess - 1;
            } else {
                System.out.println("Invalid input! Please type: 'low', 'high', or 'correct'.");
                attempt--; // Don’t count invalid input as attempt
                continue;
            }

            printDivider();
        }

        System.out.println("\n==================================================");
        System.out.println(" GAME OVER! I couldn't guess your number in " + maxAttempts + " attempts.");
        System.out.println(" Better luck next time!");
        System.out.println("==================================================");
    }

    // Method to print game banner
    private static void printBanner() {
        System.out.println("==================================================");
        System.out.println("            WELCOME TO THE MINDREADER GAME        ");
        System.out.println("==================================================");
    }

    // Method to print divider lines
    private static void printDivider() {
        System.out.println("--------------------------------------------------");
    }
}
