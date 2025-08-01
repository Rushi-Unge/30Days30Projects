package 11_MovieRater.src.util;

import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "11_MovieRater/src/ratings.txt";

    public static void saveToFile(List<Movie> movies){
        try(PrinyWriter writer = new PrintWriter(new FileWriter(FILE_NAME))){
            for(Movie movie:movies){
                writer.println(movie.getTitle() + "," +movie.getRating().getStars());
            }
            System.out.println("Ratings saved to file.");
        } catch(IOException e){
            System.out.println("Error saving file: "+e.getMessage());
        }
    }
}
