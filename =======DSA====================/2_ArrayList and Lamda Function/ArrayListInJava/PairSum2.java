package T08_ArrayListInJava;

import java.util.*;

public class PairSum2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(3);
        int t = 2;
        System.out.println(twoPointerApproach(list, t));
    }

    public static int piviot(ArrayList<Integer> list) {
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int mid = i + (j - 1) / 2;
            if (list.get(mid) < list.get(mid + 1) && list.get(mid) < list.get(list.size() - 1)) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static ArrayList<ArrayList<Integer>> twoPointerApproach(ArrayList<Integer> ll, int t) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = ll.size();
        int i = piviot(ll);
        int j = i - 1;
        if (j < 0) {
            j += n;
        }
        while (i < j) {
            ArrayList<Integer> temp = new ArrayList<>();
            if ((ll.get(i) + ll.get(j)) == t) {
                temp.add(ll.get(i));
                temp.add(ll.get(j));
                ans.add(temp);
                i++;
                j--;
                if (i >= n) {
                    i = i % n;
                }
                if (j < 0) {
                    j += n;
                }

            } else if ((ll.get(i) + ll.get(j)) > t) {
                j--;
                if (j < 0) {
                    j += n;
                }
            } else {
                i++;
                if (i >= n) {
                    i = i % n;
                }
            }
        }
        return ans;
    }

}
