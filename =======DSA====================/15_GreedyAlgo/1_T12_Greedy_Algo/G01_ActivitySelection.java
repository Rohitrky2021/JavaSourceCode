
import java.util.*;
import java.util.Arrays;
import java.util.Comparator;

public class G01_ActivitySelection {
    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        int activitys[][] = new int[end.length][3];

        for (int i = 0; i < start.length; i++) {
            activitys[i][0] = i;
            activitys[i][1] = start[i];
            activitys[i][2] = end[i];
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer( );
        pq.add( );

        Arrays.sort(activitys, Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> list = new ArrayList<>();

        int maxAct = 1;
        list.add(activitys[0][0]);
        int lastEnd = activitys[0][2];

        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                lastEnd = activitys[i][2];
                maxAct++;
                list.add(activitys[i][0]);
            }
        }
        System.out.println(maxAct);
        System.out.println(list);
    }
}
