
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

// This Is Also Meeting Room 1  -> Just return false if ( [1] < lastending_point  )

public class minactivity {
    public static void main(String arg[]) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 10, 9 };

        int activities[][] = new int[start.length][3];
        for (int i = 0; i < activities.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        // ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        // Arrays.sort(activities, Comparator.comparingInt(o -> o[1]));
        // Collections.sort(A, Comparator.comparingInt(o -> o.get(2)));

        // Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));
        Arrays.sort(activities,(a,b)->a[2]-b[2]);

        for (int[] arr : activities) {
            System.out.println(Arrays.toString(arr));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int max = 0;
        ans.add(activities[0][0]);  // First tho lena he lena hai 
        int lastEnd = activities[0][2];

        for (int i = 1; i < activities.length; i++) {
            if (activities[i][1] >= lastEnd) {
                max++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        // char l="";
        System.out.println("The maximum number of workers required: " + (max + 1));
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}
