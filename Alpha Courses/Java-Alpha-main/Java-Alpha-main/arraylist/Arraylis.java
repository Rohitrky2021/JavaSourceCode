import java.util.ArrayList;
public class Arraylis{
    public static void main(String[] args) {
       ArrayList<Integer> list = new ArrayList<>();
       ArrayList<String> list2 =new ArrayList<>();
       ArrayList<Boolean> list3 = new ArrayList<>(); 

       list.add(1);
       list.add(2);
       list.add(3);
       list.add(4);
       list.add(5);
       list.add(6);

       System.out.println(list);
       int ans = list.get(2);
       System.out.println(ans);
       list.remove(3);
       list.set(3, 10);
       System.out.println(list);
       System.out.println(list.contains(4));
       System.out.println(list.size());
 

    }
}