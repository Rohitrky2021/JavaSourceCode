import java.util.ArrayList;
public class max {
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


       for(int  i = 0 ;  i < list.size() ; i++ ){
        //if(max < list.get(i)){
          //  max = list.get(i);
        //}
        max = Math.max(max, list.get(i));
       }

       System.out.println(max);
    }
}
