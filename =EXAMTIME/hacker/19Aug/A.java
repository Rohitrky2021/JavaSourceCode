import java.util.*;

public class A {

    public static int solve(int N, int[] people, int[] starting, int[] ending) {
        // Create a 2D array to store the meetings (start, end, people)
        int[][] meetings = new int[N][3];
        for (int i = 0; i < N; i++) {
            meetings[i][0] = starting[i];
            meetings[i][1] = ending[i];
            meetings[i][2] = people[i];
        }

        // Sort the meetings by their ending times, and by start time for tie-breaking
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] != b[1]) {
                return Long.compare(a[1], b[1]);
            } else if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }else{
                return Integer.compare(b[2] , a[2]);
            }
        });

        // Track the end time of the last meeting we scheduled
        int lastEndTime = -1;
        int totalPeopleWhoCanMeet = 0;

        for (int i = 0; i < N; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            int numPeople = meetings[i][2];

            if (start > lastEndTime) {
                // Schedule this meeting
                lastEndTime = end;
                totalPeopleWhoCanMeet += numPeople;
            }
        }

        // Total number of people
        int totalPeople = Arrays.stream(people).sum();

        // Calculate the minimum number of people who cannot meet
        int peopleWhoCannotMeet = totalPeople - totalPeopleWhoCanMeet;

        return peopleWhoCannotMeet;
    }

    public static void main(String[] args) {
        // Example usage
        int N = 5;
        int[] people = {4, 3, 5, 6, 10};
        int[] starting = {1, 2, 3, 6, 5};
        int[] ending = {1, 2, 5, 7, 7};

        System.out.println(solve(N, people, starting, ending));  // Output should be 10
    }
}
