import java.util.Scanner;

public class GameVault {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    TicTacToe.play();
                    break;
                case 2:
                    GuessNumber.play();
                    break;
                case 0:
                    System.out.println("🎮 Exiting GameVault. Thanks for playing!");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Try again!");
            }

        } while (choice != 0);

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("\n🎮================ GameVault ================🎮");
        System.out.println("1. Play Tic Tac Toe");
        System.out.println("2. Play Guess The Number");
        System.out.println("0. Exit");
        System.out.println("============================================");
    }
}
