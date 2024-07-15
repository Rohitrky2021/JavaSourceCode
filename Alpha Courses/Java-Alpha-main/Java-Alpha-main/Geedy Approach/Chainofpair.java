import java.util.*;
public class Chainofpair {
    public static void main(String[] args) {
        int pair[][]= {{5,24},{39,60},{5,28},{27,40},{50,90}};
        //sorting 
        Arrays.sort(pair,Comparator.comparingDouble(o->o[1]));
        
        int ans =1;
        int lastnum=pair[0][1];
        
        for(int i = 1 ; i < pair.length ; i++){
            if( lastnum  < pair[i][0]){
                ans++;
                lastnum=pair[i][1];
            }
        }
        System.out.println(ans);
    }
}
