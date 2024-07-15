package T08_ArrayListInJava;

import java.util.ArrayList;

public class PairSum {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int t = 5;

        System.out.println(bruteForce(list, t));
        System.out.println(twoPointerApproach(list, t));

    }

    public static ArrayList<ArrayList<Integer>> bruteForce(ArrayList<Integer> ll, int t) {
        ArrayList<ArrayList<Integer>> ans1 = new ArrayList<>();
        int n = ll.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ArrayList<Integer> temp1 = new ArrayList<>();
                if ((ll.get(i) + ll.get(j)) == t) {
                    temp1.add(ll.get(i));
                    temp1.add(ll.get(j));
                    ans1.add(temp1);
                }
            }
        }

        return ans1;
    }

    public static ArrayList<ArrayList<Integer>> twoPointerApproach(ArrayList<Integer> ll, int t) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int i = 0;
        int j = ll.size() - 1;
        while (i < j) {
            ArrayList<Integer> temp = new ArrayList<>();
            if ((ll.get(i) + ll.get(j)) == t) {
                temp.add(ll.get(i));
                temp.add(ll.get(j));
                ans.add(temp);
                i++;
                j--;

            } else if ((ll.get(i) + ll.get(j)) > t) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }
}
