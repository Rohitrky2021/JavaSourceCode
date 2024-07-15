import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.interviewbit.com/problems/meeting-rooms/

public class Meeting2UsingHeap {
// public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        Collections.sort(A, Comparator.comparingInt(o -> o.get(0))); // Sort meetings based on start times
        
        PriorityQueue<Integer> endTimes = new PriorityQueue<>(); // Min heap of ending times
        endTimes.add(A.get(0).get(1));
        
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i).get(0) >= endTimes.peek()) {
                // This meeting can reuse a room, remove the earliest ending time
                endTimes.poll();
            }
            endTimes.add(A.get(i).get(1)); // Add the ending time of the current meeting
        }
        
        return endTimes.size(); // The size of the priority queue represents the required number of rooms
    }
}
