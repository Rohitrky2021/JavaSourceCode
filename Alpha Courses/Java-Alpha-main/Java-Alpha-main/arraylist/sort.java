import java.util.ArrayList;
import java.util.Collections;
public class sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
       ArrayList<String> list2 =new ArrayList<>();
       ArrayList<Boolean> list3 = new ArrayList<>(); 
        int max = Integer.MIN_VALUE;
       list.add(1);
       list.add(5);
       list.add(7);
       list.add(9);
       list.add(11);
       list.add(6);

       System.out.println(list);
       Collections.sort(list);
       System.out.println(list);

       //decending

       Collections.sort(list,Collections.reverseOrder());
       System.out.println(list);

    }
}
