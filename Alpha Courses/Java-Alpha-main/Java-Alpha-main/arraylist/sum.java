import java.util.*;

public class sum {
    private static boolean pairsum(ArrayList<Integer> list , int tar) {
        for(int i = 0 ; i < list.size()-1 ; i++ ){
            for(int j = i+1 ; j < list.size() ; j++ ){
                if(list.get(i)+list.get(j)==tar){
                    return true;
                }
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
        int tar = 5 ;
        // 1 8 6 2 5 4 8 3 7 
        System.out.println(pairsum(list , tar));
    }

    
    
}
