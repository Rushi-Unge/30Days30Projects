import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizWiz {

    static class Question {
        String question;
        String[] options;
        int correctOption;

        Question(String question, String[] options, int correctOption) {
            this.question = question;
            this.options = options;
            this.correctOption = correctOption;
        }

        void displayQuestion(int qNum) {
            System.out.println("\n----------------------------------------");
            System.out.println("Q" + qNum + ": " + question);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ") " + options[i]);
            }
        }
    }

    public static void main(String[] args) {
        List<Question> questions = loadQuestions("questions.txt");

        if (questions == null || questions.isEmpty()) {
            System.out.println("No questions found. Exiting...");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("========================================");
        System.out.println("      Welcome to QuizWiz CLI Quiz       ");
        System.out.println("========================================\n");

        System.out.print("Enter your name: ");
        String userName = sc.nextLine().trim();
        System.out.println("\nHello " + userName + "! Let's begin the quiz.\n");

        int qNum = 1;
        for (Question q : questions) {
            q.displayQuestion(qNum++);

            System.out.print("Your answer (1-4): ");
            int ans = -1;

            try {
                ans = Integer.parseInt(sc.nextLine());
                if (ans < 1 || ans > 4) {
                    System.out.println("Invalid choice. Answer must be between 1 and 4.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Skipping question.");
                continue;
            }

            if (ans == q.correctOption) {
                System.out.println("Correct answer!");
                score++;
            } else {
                System.out.println("Wrong answer. Correct option was: " + q.correctOption);
            }
        }

        System.out.println("\n========================================");
        System.out.println("               Quiz Complete            ");
        System.out.println("========================================");
        System.out.println("Participant: " + userName);
        System.out.println("Score: " + score + " out of " + questions.size());

        double percentage = (score * 100.0) / questions.size();
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + calculateGrade(percentage));

        System.out.println("========================================");
        System.out.println("       Thank you for playing QuizWiz     ");
        System.out.println("========================================");

        sc.close();
    }

    static List<Question> loadQuestions(String filename) {
        List<Question> questionList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String qText = line;
                String[] options = new String[4];
                for (int i = 0; i < 4; i++) {
                    options[i] = br.readLine();
                }
                int correct = Integer.parseInt(br.readLine().trim()); // e.g., 1-4
                questionList.add(new Question(qText, options, correct));
                br.readLine(); // skip empty line
            }
        } catch (IOException e) {
            System.out.println("Error reading questions file: " + e.getMessage());
        }
        return questionList;
    }

    static String calculateGrade(double percent) {
        if (percent >= 90) return "A+";
        else if (percent >= 75) return "A";
        else if (percent >= 60) return "B";
        else if (percent >= 50) return "C";
        else return "F";
    }
}
