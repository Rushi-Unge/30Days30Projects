package PassGuard.src;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PassGuard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ANSI Color Codes for Stylling
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String YELLOW = "\u001B[33m";
        final String GREEN = "\u001B[32m";
        final String CYAN = "\u001B[36m";
        final String BOLD = "\u001B[1m";

        System.out.println(BOLD + CYAN + "╔═══════════════════════════════════════╗");
        System.out.println("║          Welcome to PassGuard         ║");
        System.out.println("╚═══════════════════════════════════════╝" + RESET);
        System.out.print("\nEnter a password to check strength: ");
        String password = sc.nextLine();

        int strengthScore = 0;
        boolean hasLower = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasUpper = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecial = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
        boolean hasLength = password.length() >= 8;

        if (hasLength) strengthScore++;
        if (hasLower) strengthScore++;
        if (hasUpper) strengthScore++;
        if (hasDigit) strengthScore++;
        if (hasSpecial) strengthScore++;

        String strengthLabel;
        String strengthColor;

        if (strengthScore <= 2) {
            strengthLabel = "Weak Password";
            strengthColor = RED;
        } else if (strengthScore <= 4) {
            strengthLabel = "Medium Password";
            strengthColor = YELLOW;
        } else {
            strengthLabel = "Strong Password";
            strengthColor = GREEN;
        }

        System.out.println(BOLD + "\n──────────── Password Analysis ────────────" + RESET);
        System.out.println(strengthColor + BOLD + ">> " + strengthLabel + RESET);

        System.out.println(BOLD + "\n──────────── Detailed Breakdown ───────────" + RESET);
        System.out.printf("• %-13s: %s\n", "Length", hasLength ? GREEN + "Sufficient" : RED + "Too short" + RESET);
        System.out.printf("• %-13s: %s\n", "Lowercase", hasLower ? GREEN + "Present" : RED + "Missing" + RESET);
        System.out.printf("• %-13s: %s\n", "Uppercase", hasUpper ? GREEN + "Present" : RED + "Missing" + RESET);
        System.out.printf("• %-13s: %s\n", "Digits", hasDigit ? GREEN + "Present" : RED + "Missing" + RESET);
        System.out.printf("• %-13s: %s\n", "Special Char", hasSpecial ? GREEN + "Present" : RED + "Missing" + RESET);

        System.out.println(BOLD + "\nThank you for using PassGuard! Stay safe. " + RESET);
    }
}
