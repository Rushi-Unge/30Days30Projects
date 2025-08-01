public class Movie {
    private String name;
    private int rating;

    public Movie(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " ⭐ " + rating + "/5";
    }
}
