import java.time.*;
import java.util.*;

public class TypingGame {
    private final String difficulty;
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> sentences;

    public TypingGame(String difficulty) {
        this.difficulty = difficulty;
        this.sentences = SentenceLoader.loadSentences(difficulty);
    }

    public void start() {
        if (sentences == null || sentences.isEmpty()) {
            System.out.println("Error: No sentences found for difficulty: " + difficulty);
            return;
        }

        String sentence = sentences.get(new Random().nextInt(sentences.size()));
        System.out.println("\n=== Typing Challenge: " + difficulty.toUpperCase() + " ===");
        System.out.println("Type the following sentence:\n");
        System.out.println(sentence);
        System.out.print("\nYour input: ");

        Instant start = Instant.now();
        String typed = scanner.nextLine();
        Instant end = Instant.now();

        long timeTakenMillis = Duration.between(start, end).toMillis();
        double seconds = timeTakenMillis / 1000.0;
        double cpm = (typed.length() / seconds) * 60;
        int accuracy = calculateAccuracy(sentence, typed);

        System.out.println("\n--- Result Summary ---");
        System.out.printf("Time     : %.2f seconds\n", seconds);
        System.out.printf("Speed    : %.2f CPM\n", cpm);
        System.out.println("Accuracy : " + accuracy + "%");

        double highScore = HighScoreManager.loadHighScore();
        if (cpm > highScore) {
            System.out.println("New High Score!");
            HighScoreManager.saveHighScore(cpm);
        }

        System.out.println("\n--- Comparison ---");
        System.out.println("Expected : " + sentence);
        System.out.println("Typed    : " + typed);

        System.out.print("\nTry again? (Y/N): ");
        String retry = scanner.nextLine().trim().toLowerCase();
        if (retry.equals("y")) {
            start();
        } else {
            System.out.println("Thanks for playing.");
        }
    }

    private int calculateAccuracy(String original, String typed) {
        int correct = 0;
        int minLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < minLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                correct++;
            }
        }

        return (int) ((correct / (double) original.length()) * 100);
    }
}
