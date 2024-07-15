import java.util.*;
public class Knapsap {
    public static void main(String[] args) {
        int value[] = {60,100,120};
        int weight[] = {10,20,30};
        int w=50;

        //sorting
        double ratio[][] = new double[value.length][2]; 
        // 0th col = idx  , 1th ratio;

        for(int i =0; i < value.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = (double)value[i]/(double)weight[i];
        }
    
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        //work
        int cap = w; 
        int ans=0;
        for(int i = value.length-1; i >= 0 ; i--){
            int idx = (int)ratio[i][0];
            if(cap >= weight[idx]){
                cap =cap-weight[idx];
                ans=ans + value[idx];
            }else{
                ans =ans + (int)(ratio[idx][1]*cap);
                cap=0;
                break;
            }
        }
        System.out.println(ans);
    }
}
