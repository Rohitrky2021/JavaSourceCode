import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int minProcessingTime(List<Integer> my, List<Integer> rohar) {
        int n = my.size();
        int[] availableTime = new int[n];

        // Convert the List<Integer> rohar to an array taskArray
        int[] taskArray = new int[rohar.size()];
        for (int i = 0; i < rohar.size(); i++) {
            taskArray[i] = rohar.get(i);
        }

        // Convert the List<Integer> my to an array availableTime
        for (int i = 0; i < my.size(); i++) {
            availableTime[i] = my.get(i);
        }

        // Sort both arrays
        Arrays.sort(taskArray);
        Arrays.sort(availableTime,Collections.reverseOrder());

        // Find the minimum processing time using the findProcessor method
        int processor = findProcessor(availableTime, taskArray);

        // Return -1 if no valid processor is found, otherwise return the processor's time
        return processor == Integer.MAX_VALUE ? -1 : processor;
    }

    private int findProcessor(int[] my, int[] rohar) {
        int minTime = 0;
        int processor = -1;

        for (int i = 0; i < my.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (i * 4 + j < rohar.length) {
                    minTime = Math.max(my[i] + rohar[i * 4 + j], minTime); // Change Math.max to Math.min
                } else {
                    break;
                }
            }
        }

        return minTime;
    }
}
