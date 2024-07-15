import java.util.*;
public class watertrap{
    public static int trapwater(ArrayList<Integer> list){
        int max = 0 ; 
        int lp= 0 ; 
        int rp= list.size()-1;


        while(lp < rp ){
            int ht = Math.min(list.get(lp),list.get(rp));
            int width = rp-lp;
            int current = ht*width;
            max = Math.max(max, current);

            //update ptr

            if(list.get(lp) < list.get(rp)){
                lp++;
            }else {
                rp--;
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
        System.out.println(trapwater(list));
    }
}
