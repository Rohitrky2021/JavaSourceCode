import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

// public class minactivity  {
    public class Meetingroom {
        class Solution {
            public int minMeetingRooms(int[][] intervals) {
              final int n = intervals.length;
              int ans = 0;
              int[] starts = new int[n];
              int[] ends = new int[n];
          
              for (int i = 0; i < n; ++i) {
                starts[i] = intervals[i][0];
                ends[i] = intervals[i][1];
              }
          
              Arrays.sort(starts);
              Arrays.sort(ends);
          
              // J points to ends
              for (int i = 0, j = 0; i < n; ++i)
                if (starts[i] < ends[j])
                  ++ans;
                else
                  ++j;
          
              return ans;
            }
          }
          
}

// Same but just while loop---used 
// https://www.interviewbit.com/problems/meeting-rooms/

public int solve(ArrayList<ArrayList<Integer>> A) {
            // Create an ArrayList to store the meetings' start and end times separately
            ArrayList<Integer> startTimes = new ArrayList<>();
            ArrayList<Integer> endTimes = new ArrayList<>();
            
            // Fill the start and end times arrays
            for (ArrayList<Integer> meeting : A) {
                startTimes.add(meeting.get(0));
                endTimes.add(meeting.get(1));
            }
            
            // Sort the start and end times arrays
            Collections.sort(startTimes);
            Collections.sort(endTimes);
    
            int maxRooms = 0;
            int roomsNeeded = 0;
            int startIdx = 0;
            int endIdx = 0;
    
            while (startIdx < startTimes.size()) {
                if (startTimes.get(startIdx) < endTimes.get(endIdx)) {
                    // A new meeting is starting before a meeting ends, so a new room is needed
                    roomsNeeded++;
                    startIdx++;
                } else {
                    // A meeting has ended, so one room is freed up
                    // roomsNeeded--;
                     startIdx++;
                    endIdx++;
                }
    
                // Update the maximum number of rooms needed
                // maxRooms = Math.max(maxRooms, roomsNeeded);
            }
    
            return roomsNeeded;
        }