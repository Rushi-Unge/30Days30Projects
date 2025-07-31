
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class JavaClock {
    

    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CLEAR_SCREEN = "\033[H\033[2J";


    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy | HH:mm:ss z");

        ZoneId[] zones = {
            ZoneId.of("Asia/Kolkata"),
            ZoneId.of("America/New_York"),
            ZoneId.of("Europe/London"),
            ZoneId.of("Asia/Tokyo"),
            ZoneId.of("Australia/Sydney"),
            ZoneId.of("Africa/Nairobi"),
        };

        String[] zoneLabels = {
            " India        ",
            " New York     ",
            " London       ",
            " Tokyo        ",
            " Sydney       ",
            " Nairobi      "
        };

        while (true) {
            System.out.print(CLEAR_SCREEN);
            System.out.flush();

            System.out.println(MAGENTA + "╔══════════════════════════════╗");
            System.out.println("║      Real-Time JavaClock     ║");
            System.out.println("╚══════════════════════════════╝" + RESET);
            System.out.println();

            for (int i = 0; i < zones.length; i++) {
                ZonedDateTime zdt = ZonedDateTime.now(zones[i]);
                String timeString = zdt.format(formatter);

                String color = switch (i % 4) {
                    case 0 -> CYAN;
                    case 1 -> GREEN;
                    case 2 -> YELLOW;
                    default -> BLUE;
                };

                System.out.println(color + zoneLabels[i]  + timeString + RESET);
            }

            try {
                Thread.sleep(1000); // refresh every second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}