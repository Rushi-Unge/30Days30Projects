import service.MovieService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieService movieService = new MovieService();

        while (true) {
            System.out.println("\n Movie Rater Menu: "); 
            System.out.println("1. Add Movie Rating.");
            System.out.println("2. List Movies (Top Rated First)");
            System.out.println("4. Exit");
            System.out.println("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Movie Title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter rating (1-5): ");
                    int stars = sc.nextInt();
                    if(stars < 1 || stars > 5){
                        System.out.println("Invalid rating.");
                    }else{
                        movieService.addMovie(title,stars);
                        System.out.println("Movie rated!");
                    }
                }
                case 2 -> movieService.listMovies();
                case 3 ->FileManager.saveToFile(movieService.getMovies());
                case 4 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }    
                default -> System.out.println("Invalid Choice.");
            }
            
        }
    }
}

