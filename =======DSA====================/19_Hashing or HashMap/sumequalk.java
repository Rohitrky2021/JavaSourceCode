import java.util.HashMap;

public class sumequalk {

    // this not for SubSequence Only for SubArray 
    public static void main(String args[]) {
        int arr[] = { 10, 2, -2, -20, 20 };
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);

        int sum = 0, k = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hm.containsKey(sum - k)) {
                ans += hm.get(sum - k);
            }

            hm.put(sum, hm.getOrDefault(sum, 0) + 1);

        }
        System.out.println(ans);
    }
}
