import java.io.*;

public class HighScoreManager {
    private static final String FILE_PATH = "highscore.txt";

    public static double loadHighScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            return Double.parseDouble(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            return 0.0; 
        }
    }

    public static void saveHighScore(double score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(String.valueOf(score));
        } catch (IOException e) {
            System.out.println("Couldn't save high score.");
        }
    }
}
