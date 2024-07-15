import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < T; i++) {
            String startDateTimeStr = scanner.nextLine();
            String endDateTimeStr = scanner.nextLine();
            String result = classifyContest(startDateTimeStr, endDateTimeStr);
            System.out.println(result);
        }
        scanner.close();
    }

    public static String classifyContest(String startDateTimeStr, String endDateTimeStr) {
        // Parse input strings to LocalDateTime objects
        LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeStr, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeStr, DateTimeFormatter.ISO_DATE_TIME);

        // Convert to IST timezone
        ZoneId istZone = ZoneId.of("Asia/Kolkata");
        ZonedDateTime startIST = startDateTime.atZone(istZone);
        ZonedDateTime endIST = endDateTime.atZone(istZone);

        // Assumed current time
        LocalDateTime currentTime = LocalDateTime.of(2023, 1, 1, 15, 0); // 1 Jan 2023, 3:00 PM IST

        // Compare with current time and classify contest
        if (startIST.isBefore(currentTime) && endIST.isAfter(currentTime)) {
            return "ONGOING";
        } else if (startIST.isAfter(currentTime) && startIST.toLocalDate().isEqual(currentTime.toLocalDate())) {
            return "UPCOMING";
        } else if (startIST.isAfter(currentTime)) {
            return "LATER";
        } else {
            return "NULL";
        }
    }
}
