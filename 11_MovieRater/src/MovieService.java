import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void displayMovies() {
        movies.stream()
              .sorted(Comparator.comparingInt(Movie::getRating).reversed())
              .forEach(System.out::println);
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
