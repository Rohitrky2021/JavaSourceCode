import java.util.*;

public class Main2 {
    public static class Solution {
        public int[] solve(int A, int[][] B) {
            int[] schedule = new int[A + 1];
            Arrays.fill(schedule, 0);

            // Priority queue to store tasks with their deadlines in ascending order.
            PriorityQueue<int[]> taskQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

            // Add all tasks to the priority queue.
            for (int[] task : B) {
                taskQueue.offer(task);
            }

            // Iterate through the days.
            for (int day = 1; day <= A; day++) {
                if (!taskQueue.isEmpty()) {
                    int[] task = taskQueue.peek();

                    // Check if the pending task can be completed on or before this day.
                    if (task[1] >= day) {
                        taskQueue.poll();
                        schedule[day] = task[0]; // Assign the task number to this day.
                    }
                }

                if (schedule[day] == 0) {
                    schedule[day] = -1; // Mark this day as a rest day.
                }
            }

            int pendingTasks = taskQueue.size();
            if (pendingTasks > 0) {
                return new int[]{-1}; // Some tasks couldn't be completed before their deadlines.
            }

            int[] result = new int[A + 1];
            result[0] = -1;
            for (int i = 1; i <= A; i++) {
                result[i] = schedule[i]; // Copy the schedule array to the result array.
            }

            return result;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            int A1 = 2;
            int[][] B1 = {{1, 2, 1}};
            int[] output1 = solution.solve(A1, B1);
            System.out.println(Arrays.toString(output1)); // Output: [-1, 1, 2]

            int A2 = 3;
            int[][] B2 = {{1, 2, 2}};
            int[] output2 = solution.solve(A2, B2);
            System.out.println(Arrays.toString(output2)); // Output: [-1]
        }
    }
}
