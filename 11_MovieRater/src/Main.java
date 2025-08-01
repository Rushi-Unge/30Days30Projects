import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieService movieService = new MovieService(); 
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n===== Movie Rater CLI =====");
            System.out.println("1. Add Movie");
            System.out.println("2. Show Movies");
            System.out.println("3. Save to File");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("Movie Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Rating (1–5): ");
                    int rating = scanner.nextInt();
                    scanner.nextLine();
                    movieService.addMovie(new Movie(name, rating));
                }
                case 2 -> movieService.displayMovies();
                case 3 -> FileManager.saveToFile(movieService.getMovies());
                case 4 -> {
                    running = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}
