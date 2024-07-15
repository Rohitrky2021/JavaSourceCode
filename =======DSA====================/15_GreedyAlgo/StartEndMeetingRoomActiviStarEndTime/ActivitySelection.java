import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

public class ActivitySelection {
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);

        // int start[]={1,3,3,5,7};
        int n=sc.nextInt();
        int start[]=new int[n];
        for (int i = 0; i < start.length; i++) {
            start[i]=sc.nextInt();
        }
        // int m=sc.nextInt();
        int end[]=new int[n];
        for (int i = 0; i < end.length; i++) {
            end[i]=sc.nextInt();
        }

        // int end[]={2,2,1,2,1};

        int activities[][]=new int[start.length][3];
        for (int i = 0; i < activities.length-1; i++) {
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }
// Comparator.comparingInt(keyExtractor)
        Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));
        // System.out.println(Arrays.asList(activities));
        
        System.out.println(Arrays.deepToString(activities));
        
        
        // System.out.println(Arrays.deepEquals(activities, activities));
        // Arrays.copyOf(activities, activities);
// System.out.println();
// String.copyValueOf(5)
// System.out.println(Integer.bitCount(10000));
// Integer.valueOf(1000, 10);\

// System.out.println(Integer.numberOfLeadingZeros(1010110));

// System.out.println(Integer.parseInt("01110" , 0, 5, 2));
// Arrays.copyOfRange(original, from, to, newType)


        //end basis sorted
        ArrayList<Integer> ans=new ArrayList<>();
        int max=0;
        ans.add(activities[0][0]);
        int lastend=activities[0][2];
        for(int i=0;i<start.length;i++){
            if(activities[i][1]>=lastend){
                max++;
                ans.add(i);
                lastend=activities[i][2];
            }
        }
        System.out.println("the max work are :"+max);    
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
    }
}
