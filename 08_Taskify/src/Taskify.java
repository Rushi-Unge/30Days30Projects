
import java.io.*;
import java.util.*;

public class Taskify {
    static List<Task> tasks = new ArrayList<>();
    static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {
        loadTasksFromFile();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n======== Taskify CLI - Menu =========");
            System.out.println("1. Add Task");
            System.out.println("2. Show Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String desc = sc.nextLine();
                    tasks.add(new Task(desc));
                    break;

                case 2:
                    System.out.println("Your Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    break;

                case 3:
                    System.out.print("Enter task number to mark as done: ");
                    int doneIndex = sc.nextInt() - 1;
                    if (doneIndex >= 0 && doneIndex < tasks.size()) {
                        tasks.get(doneIndex).markDone();
                    }
                    break;

                case 4:
                    System.out.print("Enter task number to delete: ");
                    int delIndex = sc.nextInt() - 1;
                    if (delIndex >= 0 && delIndex < tasks.size()) {
                        tasks.remove(delIndex);
                    }
                    break;

                case 5:
                    saveTasksToFile();
                    System.out.println("Thanks for using Taskify! ");
                    break;
            }
        } while (choice != 5);
    }

    static void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    static void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(Task.fromFileFormat(line));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
