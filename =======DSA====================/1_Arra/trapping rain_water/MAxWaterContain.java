import java.util.*;
public class MAxWaterContain {
    public static void main(String args[]){
    ArrayList<Integer> hight=new ArrayList<>() ;
    hight.add(1);
    hight.add(8);
    hight.add(6);
    hight.add(2);
    hight.add(5);
    hight.add(4);
    hight.add(8);
    hight.add(3);
    hight.add(7);
    // System.out.println(maxwa(hight));
    System.out.println(maxwater2(hight));
    // System.out.println(hight.length());
    System.out.println(hight.size());

    System.out.println(hight);
    }
    public static int maxwa(ArrayList<Integer> high){
        int maxwater=0;
        for(int i=0;i<high.size();i++){
            for(int j=i+1;j<high.size();j++){
                maxwater=Math.max((Math.min(high.get(i),high.get(j)))*(j-i),maxwater);
            }
        }
        return maxwater;
        // return 1;
    }

    
    //using the 2 pointer Approach
    public static int maxwater2(ArrayList<Integer> high){
        int maxwater=0;
        int lp=0;
        int rp=high.size()-1;
        while(lp<=rp){
            int h=Math.min(high.get(lp), high.get(rp));
            int currwater=h*(rp-lp);
            maxwater=Math.max(maxwater, currwater);
            if(high.get(lp)<high.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }
        return maxwater;
    }
}
 