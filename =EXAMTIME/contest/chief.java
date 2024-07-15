import java.util.*;


public class chief {
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
	    long T=sc.nextInt();

        ArrayList<Integer> list=new ArrayList<>();
        // int a=0;
        // int b=0;

	    while(T-->0){
            int a =sc.nextInt();
            // int b=sc.nextInt();
            for (int i = 0; i <a; i++) {
                int e=sc.nextInt();
                list.add(e);
                 }
            for (int i = 0; i <a; i++) {
                // int e=sc.nextInt();
                // list.add(e);
                System.out.print(list.get(i));
                 }     
        }
        // list.wa
       
    }}
