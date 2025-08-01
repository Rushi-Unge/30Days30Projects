package 11_MovieRater.src.model;

public class Movie {
    
    private String title ;
    private Rating rating;
    public Movie(String title , Rating rating){
        this.title = title;
        this.rating = rating;
    }

    public String getTitle(){
        return title;
    }

    public Rating getRating(){
        return rating;
    }

    @Override
    public String toString(){
        return title + "⭐" + rating.getStars() + "/s";
    }

}
