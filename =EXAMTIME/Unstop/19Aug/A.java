import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 1) {
            String singleString = scanner.next();
            System.out.println(1);
            return;
        }

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }

        Map<Integer, TreeSet<Integer>> mxHash = new HashMap<>();
        int[] hash = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (char c : arr[i].toCharArray()) {
                hash[i] ^= (1 << (c - 'a'));
            }
            if (!mxHash.containsKey(hash[i])) {
                mxHash.put(hash[i], new TreeSet<>());
            }
            mxHash.get(hash[i]).add(arr[i].length());
        }

        for (int i = 0; i < n; i++) {
            int hs = hash[i];
            mxHash.get(hs).remove(arr[i].length());
            if (!mxHash.get(hs).isEmpty()) {
                ans = Math.max(ans, arr[i].length() + mxHash.get(hs).last());
            }
            for (int mid = 0; mid < 26; mid++) {
                if (mxHash.containsKey(hs ^ (1 << mid)) && !mxHash.get(hs ^ (1 << mid)).isEmpty()) {
                    ans = Math.max(ans, arr[i].length() + mxHash.get(hs ^ (1 << mid)).last());
                }
            }
            mxHash.get(hs).add(arr[i].length());
        }

        System.out.println(ans);
    }
}
