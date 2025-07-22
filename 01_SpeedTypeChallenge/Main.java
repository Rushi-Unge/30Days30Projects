import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String difficulty;

        System.out.println("Welcome to SpeedType Challenge!");
        System.out.println("Choose difficulty: [easy / medium / hard]");
        difficulty = sc.nextLine().toLowerCase();

        if (!difficulty.equals("easy") && !difficulty.equals("medium") && !difficulty.equals("hard")) {
            System.out.println("Invalid difficulty. Please restart the game.");
            return;
        }

        TypingGame game = new TypingGame(difficulty);
        game.start();

        sc.close();
    }
}
