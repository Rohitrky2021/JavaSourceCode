import java.util.*;

public class divisible {
    public static void main(String[] args ){
    Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int arr[]=new int[2];
        ArrayList<Integer> ans=new ArrayList<>();
        while(T-->0){
            arr[0]=sc.nextInt();
            arr[1]=sc.nextInt();
            // String st=sc.nextLine();
            // st.toCharArray();
            int product=1;
            int count=0;

            while(product % arr[1]!=0){

           while(arr[0]>0){
            ans.add(arr[0]%10);
            product*=(arr[0]%10);
            arr[0]=arr[0]/10;
            
            // System.out.println(ans.toString());
           }
           System.out.println(product);
           count++;
            arr[0]+=1;

        //    for (int i = 0; i < ans.size(); i++) {

        //     product *=ans.get(i);
        //    }

        }
        System.out.println(count);
        

        }
}
}

