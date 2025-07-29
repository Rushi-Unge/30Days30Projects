public class Task {
    String description;
    boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markDone() {
        isDone = true;
    }

    public String toString() {
        return (isDone ? "[x] " : "[ ] ") + description;
    }

    public String toFileFormat() {
        return isDone + ";" + description;
    }

    public static Task fromFileFormat(String line) {
        String[] parts = line.split(";");
        Task task = new Task(parts[1]);
        task.isDone = Boolean.parseBoolean(parts[0]);
        return task;
    }
}
