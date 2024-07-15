import java.util.Arrays;
import java.util.Collections;

public class Cocolate {
    public static void main(String[] args) {
        Integer costVer[] = {2,1,3,1,4}; // m-1
        Integer costHor[] = {4,1,2};    // n-1

        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());

        int h=0,v=0;
        int hp=1,vp=1;
        int cost=0;

        while(h < costHor.length && v < costVer.length){
            if(costVer[v] <= costHor[h]){ //horizontal cut
                cost += (costHor[h]*vp);
                hp++;
                h++;
            }else{ // vertical cut
                cost += (costVer[v]*hp);
                vp++;
                v++;
            }
        }
        while ( h < costHor.length){
            cost += (costHor[v]*vp);
                hp++;
                h++;
        }

        while(v< costVer.length){
            cost += (costVer[v]*hp);
                vp++;
                v++;
        }

        System.out.println(cost);
    }
}
