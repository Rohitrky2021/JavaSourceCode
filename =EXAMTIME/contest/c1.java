import java.util.*;
public class c1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long marks[]=new long[n];
        // ArrayList<Integer> list=new ArrayList<>();
        for( int i=0;i<n;i++){
            marks[i]=sc.nextLong();
            // System.out.println(marks[i]);
        }
        // int marks[]=new int[n];
        Arrays.sort(marks);
        // int sort[]=marks;


        // even(marks);
        max(marks);
        // System.out.println(marks.length);
        // System.out.println(marks[0]);
        // for( int i=0;i<n;i++){
            
        //     // marks[i]=sc.nextInt();
        //     System.out.println(marks[i]);
        // }
       
 
        // sort
        // maxval(marks);
    }
    public static void max(long marks[]){
        int i=0;
       int  s=i;
       int f=1;
    //    System.out.println(marks[i]);
       while(f<marks.length){
        s=s+1;
        f=f+2;
        if(f>=marks.length-1){
            System.out.println(marks[s]);
            break;
        }
       }
    //    System.out.println(marks[s]);
    }
    public static void even(long marks[]){
        int sum=0;
        for(int i=0;i<marks.length;i++){
             sum+=marks[i];
        }
        if(sum%2==0){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}


    












































































