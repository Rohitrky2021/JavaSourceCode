import java.util.*;
public class Pairsum2 {
    private static boolean pairsum(ArrayList<Integer> list , int tar) {
        int i ;
        int n = list.size();
        for( i = 0 ; i < n-1; i++){
            if(list.get(i) > list.get(i+1)){
                break;
            }

        }
        int lp = i+1 ; 
        int rp = i;
        
        while(lp != rp ){
            if(tar == list.get(rp)+list.get(lp)){
                return true;
            }

            if(list.get(lp) + list.get(rp)>tar){
                rp = (n+rp-1)%n;
            }else{
                lp = (lp+n)%2;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int tar = 16 ;
        // 1 2 3 4 5 6  
        System.out.println(pairsum(list , tar));
    }
}
