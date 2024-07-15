import java.util.*;

public class ChainLengthMax{
    public static void main(String args[]){//O(nlogn)
        int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o ->o[1]));

        int chainlength=1;
        int endofpair=pairs[0][1];
        
        for(int i=0;i<pairs.length;i++){
            if(pairs[i][0]>endofpair){
                endofpair=pairs[i][1];
                chainlength++;
            }
        }
        // if(pairs)
            System.out.println("the max activity are or Length of Chain :"+ chainlength );

    }
}

