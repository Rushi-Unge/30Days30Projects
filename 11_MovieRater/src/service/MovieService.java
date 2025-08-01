import java.util.ArrayList;

package 11_MovieRater.src.service;

public class MovieService {
    private List<Movie> movieList =  new ArrayList<>();

    public void addMovie(String title,int stars){
        Rating rating = Rating.fromInt(stars);
        movieList.add(new Movie(title, rating));
    }

    public void listMovies() {
        if(movieList.isEmpty()){
            System.out.println("No movies rated yet.");
            return;
        }

        movieList.sort((m1,m2) -> Integer.compare(m2.getRating().getStars(), m1.getRating().getStars()));
        for(Movie m:movieList){
            System.out.println(". "+m);
        }

    }

    public List<Movie> getMovies(){
        return movieList;
    }

}
