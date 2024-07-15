import java.util.*;
public class water {

    public static int maxwater(ArrayList<Integer> list){
        int max = 0;
        for(int i = 0 ; i < list.size()-1; i++){
            for(int j = i+1 ; j < list.size() ; j++){
                int height = Math.min(list.get(i),list.get(j));
                int width  = j -i ;
                int ans = height*width;
                if(max < ans){
                    max = ans;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        // 1 8 6 2 5 4 8 3 7 
        System.out.println(maxwater(list));
    }
}
