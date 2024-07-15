import java.util.*;
public class UN {
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        HashSet<Integer> U = new HashSet<>();
        HashSet<Integer> I = new HashSet<>();

        for(int i = 0 ; i < arr1.length ;i++ ){
            U.add(arr1[i]);
            I.add(arr1[i]);

        }
        int c=0;
        for(int i = 0 ; i < arr2.length ;i++ ){
            U.add(arr2[i]);
            if(I.contains(arr2[i])){
                I.remove(arr2[i]);
                c++;
            }
        }
       System.out.println(U.size());
       System.out.println(c);
       
    }
}
