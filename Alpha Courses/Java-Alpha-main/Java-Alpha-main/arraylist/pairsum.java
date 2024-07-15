import java.util.*;
public class pairsum{
    private static boolean pairsum(ArrayList<Integer> list , int tar) {
        
        int lp = 0 ; 
        int rp = list.size()-1;

        while(lp < rp ){
            if(tar == list.get(rp)+list.get(lp)){
                return true;
            }

            if(list.get(lp) + list.get(rp)>tar){
                rp--;
            }else{
                lp++;
            }
        }




        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int tar = 13 ;
        // 1 2 3 4 5 6  
        System.out.println(pairsum(list , tar));
    }

}