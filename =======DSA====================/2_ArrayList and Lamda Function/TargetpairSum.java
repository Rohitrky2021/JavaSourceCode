import java.util.ArrayList;
import java.util.*;
import java.util.Collections;

public class TargetpairSum {
    public static void main(String args[]){
        // ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int[] anns=new int[arr[arr.length-1]];
        for (int i = 0; i < anns.length; i++) {
            ArrayList<Integer> list=Arrays.asList(anns);
            if(!list.contains(i)){
                ans.add(i);
            }
        }
        ans.add(1);
        ans.add(2);
        ans.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(list);
        // target(5, list);\
        targetM2(4, list);
        // list.toString()
        // Math.pow(10, b)
        // list=list.contains(ans);
        // System.out.println(list);

        

    }
    //Brute force (N^2)
    public static void target(int x,ArrayList<Integer> list){
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(list.get(i)+list.get(j)==x){
                    System.out.println("Yes the elements are :"+"["+list.get(i)+"]"+"["+list.get(j)+"]");
                }
            }
        }

            }
            // static int lp=0;
            // static int rp=list.size()-1;
            //two pointer approach (N)
            public static void targetM2(int target,ArrayList<Integer> list){
                int lp=0;
                int rp=list.size()-1;
                // int vlp=list.get(lp);
                // int vrp=list.get(rp);
              

                while(lp<=rp){
                    if(list.get(lp)+list.get(rp)==target){
                        // System.out.println(vlp+","+vrp);
                    System.out.println(list.get(lp)+","+list.get(rp));

                    }
                
                    if(list.get(lp)+list.get(rp)>target){
                        rp--;
                    }
                    else{
                        lp++;
                    }
                    // System.out.println(list.get(lp)+","+list.get(rp));
                }

            }
}
