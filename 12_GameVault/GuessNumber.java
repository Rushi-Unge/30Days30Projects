import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("\n🔢 Welcome to Guess The Number!");
        System.out.println("Try to guess a number between 1 and 100.");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("🔼 Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("🔽 Too high!");
            } else {
                System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
            }

        } while (guess != numberToGuess);
    }
}
