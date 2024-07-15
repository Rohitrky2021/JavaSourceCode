package T08_ArrayListInJava;

import java.util.*;

public class isLonely {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();
            list.add(e);
        }
        System.out.println(bruteForce(list));
        sc.close();
    }

    public static ArrayList<Integer> bruteForce(ArrayList<Integer> ll) {
        ArrayList<Integer> ans = new ArrayList<>();
        Collections.sort(ll);
        int i;
        for (i = 0; i < ll.size() - 1; i++) {
            if ((ll.get(i) == ll.get(i + 1) + 1) || (ll.get(i) == ll.get(i + 1) - 1) || (ll.get(i) == ll.get(i + 1))) {
                
                i++;
            } else {
                ans.add(ll.get(i));
            }
        }
        i = ll.size() - 2;
        if ((ll.get(i) == ll.get(i + 1) + 1) || (ll.get(i) == ll.get(i + 1) - 1) || (ll.get(i) == ll.get(i + 1))) {

        } else {
            ans.add(ll.get(i + 1));
        }
        return ans;
    }

}
