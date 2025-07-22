import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class SentenceLoader {
    public static List<String> loadSentences(String difficulty) {
        List<String> sentences = new ArrayList<>();
        Path path = Paths.get("01_SpeedTypeChallenge", "sentences", difficulty + ".txt");

        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    sentences.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading sentences: " + e.getMessage());
        }

        return sentences;
    }
}
