import java.util.ArrayList;
public class swap {

    public static void swapping(ArrayList<Integer> list , int idx1 , int idx2){
        int temp = list.get(idx2);
        list.set(idx2,list.get(idx1));
        list.set(idx1,temp);
    }
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
       int idx1 =  2;
       int idx2 =  4;


       System.out.print(list);

       swapping(list, idx1, idx2);
       System.out.print(list);
    }
}
