import java.util.Scanner;

public class UnitXpress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========== UnitXpress CLI ==========");
            System.out.println("1. Kilometers to Miles");
            System.out.println("2. Kilograms to Pounds");
            System.out.println("3. Celsius to Fahrenheit");
            System.out.println("4. INR to USD (Mock Rate)");
            System.out.println("5. Square Meter to Square Feet");
            System.out.println("6. Speed (km/h to mph)");
            System.out.println("0. Exit");
            System.out.print("Choose conversion type: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter distance in kilometers: ");
                    double km = sc.nextDouble();
                    System.out.println("Miles: " + km * 0.621371);
                }
                case 2 -> {
                    System.out.print("Enter weight in kilograms: ");
                    double kg = sc.nextDouble();
                    System.out.println("Pounds: " + kg * 2.20462);
                }
                case 3 -> {
                    System.out.print("Enter temperature in Celsius: ");
                    double c = sc.nextDouble();
                    System.out.println("Fahrenheit: " + (c * 9 / 5 + 32));
                }
                case 4 -> {
                    System.out.print("Enter amount in INR: ");
                    double inr = sc.nextDouble();
                    System.out.println("USD (Mock Rate 1 USD = 83 INR): " + (inr / 83));
                }
                case 5 -> {
                    System.out.print("Enter area in square meters: ");
                    double sqm = sc.nextDouble();
                    System.out.println("Square feet: " + (sqm * 10.7639));
                }
                case 6 -> {
                    System.out.print("Enter speed in kilometers per hour: ");
                    double kmh = sc.nextDouble();
                    System.out.println("Speed in miles per hour: " + (kmh * 0.621371));
                }
                case 0 -> System.out.println("Thank you for using UnitXpress.");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
