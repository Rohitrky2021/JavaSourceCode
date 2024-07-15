import java.util.Arrays;

public class pairsSum {
    public static void main(String args[]){
        int marks[]={0,1,2,3};
        // System.out.println("ur  values are");
        // for(int i=0;i<6;i++)
        // System.out.print(marks[i]+" ");
        // System.out.println();
        pairs(marks);
      


    
        
    }
    public static int change(int arr[]){
        int count=0;
        int change[]=Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        // for (int i = 0; i < change.length; i++) {
        //     System.out.println(arr[i]);
        //     // System.out.println(change[i]);
        // }
        
        // for (int i = 0; i < change.length; i++) {
        //     // System.out.println(arr[i]);
        //     System.out.println(change[i]);
        // }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=change[i]){
                count++;
            }
            if(count==0){
                count=-2;
            }
        }
        return count/2;
    }
    public static void pairs(int marks[]){
        int count=0;
        for(int i=0;i<marks.length;i++){
            int current=marks[i];
            for(int j=i;j<marks.length;j++){
                int jis=marks[j];
            System.out.print("("+current+","+jis+") ");    
            count++;
            }
            // System.out.println( );

        }
        // System.out.println(change(marks));
        

}
}
