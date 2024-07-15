import java.util.Scanner;

public class J_HR_format {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Number of alarms
            int H = scanner.nextInt(); // Hour Vlad went to bed
            int M = scanner.nextInt(); // Minute Vlad went to bed

            int[] hours = new int[n]; // Array to store the hours of the alarms
            int[] minutes = new int[n]; // Array to store the minutes of the alarms

            // Read the hours and minutes of the alarms
            for (int j = 0; j < n; j++) {
                hours[j] = scanner.nextInt();
                minutes[j] = scanner.nextInt();
            }

            // Calculate the total minutes from the time Vlad went to bed until the next alarm clock
            int sleepMinutes = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                int minutesPassed = (hours[j] - H) * 60 + (minutes[j] - M);
                if (minutesPassed <= 0) {
                    minutesPassed += 24 * 60; // Add a full day in minutes
                }
                sleepMinutes = Math.min(sleepMinutes, minutesPassed);
            }

            // Output the result in hours and minutes
            System.out.println(sleepMinutes / 60 + " " + sleepMinutes % 60);
        }

        scanner.close();
    }
}
