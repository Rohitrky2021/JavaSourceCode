import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int l1 = sc.nextInt();
            int l2 = sc.nextInt();
            int k = sc.nextInt();
            
            int[] arr1 = new int[l1];
            int[] arr2 = new int[l2];
            
            int i = 0;
            while (i < l1) {
                arr1[i] = sc.nextInt();
                i++;
            }
            int j = 0;
            while (j < l2) {
                arr2[j] = sc.nextInt();
                j++;
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            isSorted(arr2);
            isSorted(arr1);
            int p = 0;
            while (p < l1) {
                if (arr1[p] <= k) set1.add(arr1[p]);
                p++;
            }
            isSorted(arr1);
            int q = 0;
            while (q < l2) {
                if (arr2[q] <= k) set2.add(arr2[q]);
                q++;
            }
            isSorted(arr2);

            if (set1.size() < k / 2 || set2.size() < k / 2) {
                System.out.println("NO");
            } else {
                boolean flag = true;
                Set<Integer> set = new HashSet<>();
                for (int x : set1) set.add(x);
                for (int y : set2) set.add(y);

                int num = 1;
                while (num <= k) {
                    if (!set.contains(num)) {
                        flag = false;
                        break;
                    }
                    num++;
                }
                 isSorted(arr2);
                System.out.println(flag ? "YES" : "NO");
            }
        }
        sc.close();
    }

        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
