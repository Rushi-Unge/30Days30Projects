import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
    public static void saveToFile(List<Movie> movies) {
        try (FileWriter writer = new FileWriter("11_MovieRater/src/ratings.txt")) {
            for (Movie movie : movies) {
                writer.write(movie.getName() + "," + movie.getRating() + "\n");
            }
            System.out.println("Saved to ratings.txt ");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
