 
// VVIP SAMWE AS 
// https://leetcode.com/problems/maximum-profit-in-job-scheduling/?envType=daily-question&envId=2024-01-06

import java.util.*;

class ChiefOverlapping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of events
            int[] startTime = new int[n];
            int[] endTime = new int[n];
            int[] profit = new int[n];

            for (int i = 0; i < n; i++) {
                startTime[i] = scanner.nextInt();
                endTime[i] = scanner.nextInt();
                profit[i] = scanner.nextInt();
            }

            int result = maxTotalCompensation(startTime, endTime, profit);
            System.out.println(result);
        }

        scanner.close();
    }

    private static int maxTotalCompensation(int[] startTime, int[] endTime, int[] profit) {
        int numEvents = profit.length;
        Event[] events = new Event[numEvents];

        for (int i = 0; i < numEvents; ++i) {
            events[i] = new Event(endTime[i], startTime[i], profit[i]);
        }

        Arrays.sort(events, Comparator.comparingInt(event -> event.endTime));
        int[] dp = new int[numEvents + 1];

        for (int i = 0; i < numEvents; ++i) {
            // int endTimeValue = events[i].endTime;
            int startTimeValue = events[i].startTime;
            int profitValue = events[i].profit;

            int latestNonConflictEventIndex = upperBound(events, i, startTimeValue);
            dp[i + 1] = Math.max(dp[i], dp[latestNonConflictEventIndex] + profitValue);
        }

        return dp[numEvents];
    }

    private static int upperBound(Event[] events, int endIndex, int targetTime) {
        int low = 0;
        int high = endIndex;

        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid].endTime <= targetTime) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private static class Event {
        int endTime;
        int startTime;
        int profit;

        public Event(int endTime, int startTime, int profit) {
            this.endTime = endTime;
            this.startTime = startTime;
            this.profit = profit;
        }
    }
}
