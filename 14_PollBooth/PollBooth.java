import java.util.*;

public class PollBooth {

    private static final Map<String, Integer> voteCount = new HashMap<>();
    private static final Set<String> votedVoters = new HashSet<>();
    private static final List<String> candidates = Arrays.asList("Rushi", "Suraj", "Ramesh");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean votingOpen = true;

        System.out.println("--------------------------------------------------");
        System.out.println("         Welcome to the CLI Voting Booth");
        System.out.println("--------------------------------------------------");
        System.out.println("Candidates: " + String.join(", ", candidates));
        System.out.println("Voting has started. Enter your vote below.");
        System.out.println();

        while (votingOpen) {
            System.out.print("Enter your Voter ID (or type 'exit' to finish): ");
            String voterId = scanner.nextLine().trim();

            if (voterId.equalsIgnoreCase("exit")) {
                votingOpen = false;
                break;
            }

            if (voterId.isEmpty()) {
                System.out.println("Voter ID cannot be empty.\n");
                continue;
            }

            if (votedVoters.contains(voterId)) {
                System.out.println("You have already voted.\n");
                continue;
            }

            System.out.println("\nChoose a candidate to vote for:");
            for (int i = 0; i < candidates.size(); i++) {
                System.out.println((i + 1) + ". " + candidates.get(i));
            }

            System.out.print("Enter choice (1-" + candidates.size() + "): ");
            String choiceInput = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(choiceInput);
                if (choice < 1 || choice > candidates.size()) {
                    System.out.println("Invalid choice. Please try again.\n");
                    continue;
                }

                String selectedCandidate = candidates.get(choice - 1);
                voteCount.put(selectedCandidate, voteCount.getOrDefault(selectedCandidate, 0) + 1);
                votedVoters.add(voterId);

                System.out.println("Your vote for " + selectedCandidate + " has been recorded.\n");

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.\n");
            }
        }

        scanner.close();
        displayResults();
    }

    private static void displayResults() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("               Voting Session Closed");
        System.out.println("--------------------------------------------------");

        if (voteCount.isEmpty()) {
            System.out.println("No votes were cast.");
            return;
        }

        System.out.println("Final Results:");
        for (String candidate : candidates) {
            int votes = voteCount.getOrDefault(candidate, 0);
            System.out.println("- " + candidate + ": " + votes + " vote(s)");
        }

        int maxVotes = Collections.max(voteCount.values());
        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            if (entry.getValue() == maxVotes) {
                winners.add(entry.getKey());
            }
        }

        if (winners.size() == 1) {
            System.out.println("\nWinner: " + winners.get(0));
        } else {
            System.out.println("\nIt's a tie between: " + String.join(", ", winners));
        }

        System.out.println("--------------------------------------------------");
    }
}
