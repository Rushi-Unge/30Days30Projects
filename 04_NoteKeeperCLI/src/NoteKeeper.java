package NoteKeeperCLI.src;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class NoteKeeper {

    private static final String FILE_NAME = "notes.txt";
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> notes = new ArrayList<>();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        loadNotes();

        while (true) {
            System.out.println(PURPLE + "\n======  NoteKeeperCLI ======" + RESET);
            System.out.println(BLUE + "1.  Create Note");
            System.out.println("2.  View Notes");
            System.out.println("3.  Edit Note");
            System.out.println("4.  Delete Note");
            System.out.println("5.  Exit" + RESET);
            System.out.print(YELLOW + "\nChoose an option: " + RESET);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> createNote();
                case "2" -> viewNotes();
                case "3" -> editNote();
                case "4" -> deleteNote();
                case "5" -> {
                    saveNotes();
                    System.out.println(GREEN + " Notes saved. Exiting..." + RESET);
                    return;
                }
                default -> System.out.println(RED + "❗ Invalid option. Try again." + RESET);
            }
        }
    }

    private static void loadNotes() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                notes.add(line);
            }
        } catch (IOException e) {
            System.out.println(RED + " Error reading notes file." + RESET);
        }
    }

    private static void saveNotes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String note : notes) {
                writer.write(note);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(RED + " Error saving notes." + RESET);
        }
    }

    private static void createNote() {
        System.out.print(CYAN + "Enter your note: " + RESET);
        String content = scanner.nextLine();
        String timestamp = "[" + LocalDateTime.now().format(formatter) + "]";
        notes.add(timestamp + " " + content);
        System.out.println(GREEN + " Note added!" + RESET);
    }

    private static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println(RED + " No notes found." + RESET);
            return;
        }

        System.out.println(CYAN + "\n Your Notes:" + RESET);
        for (int i = 0; i < notes.size(); i++) {
            System.out.println(GREEN + (i + 1) + ". " + RESET + notes.get(i));
        }
    }

    private static void editNote() {
        viewNotes();
        if (notes.isEmpty()) return;

        System.out.print(YELLOW + "Enter note number to edit: " + RESET);
        int index = getNoteIndex();
        if (index == -1) return;

        System.out.print(CYAN + "Enter new content: " + RESET);
        String newContent = scanner.nextLine();
        String timestamp = "[" + LocalDateTime.now().format(formatter) + "]";
        notes.set(index, timestamp + " " + newContent);
        System.out.println(GREEN + " Note updated." + RESET);
    }

    private static void deleteNote() {
        viewNotes();
        if (notes.isEmpty()) return;

        System.out.print(YELLOW + "Enter note number to delete: " + RESET);
        int index = getNoteIndex();
        if (index == -1) return;

        notes.remove(index);
        System.out.println(GREEN + " Note deleted." + RESET);
    }

    private static int getNoteIndex() {
        try {
            int input = Integer.parseInt(scanner.nextLine());
            if (input < 1 || input > notes.size()) {
                System.out.println(RED + "❗ Invalid note number." + RESET);
                return -1;
            }
            return input - 1;
        } catch (NumberFormatException e) {
            System.out.println(RED + "❗ Please enter a valid number." + RESET);
            return -1;
        }
    }
}
