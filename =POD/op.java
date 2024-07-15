import java.util.*;

public class op {

    private static int supportersWithItems(int[] supporterRequests, int numStalls, int[][] stalls) {
        Arrays.sort(stalls, Comparator.comparingInt(a -> a[0]));

        int supportersObtainedItems = 0;
        for (int item : supporterRequests) {
            if (canGetItem(stalls, item)) {
                ++supportersObtainedItems;
            }
        }

        return supportersObtainedItems;
    }

    private static boolean canGetItem(int[][] stalls, int item) {
        int left = 0;
        int right = stalls.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (item >= stalls[mid][0] && item <= stalls[mid][1]) {
                return true;
            } else if (item < stalls[mid][0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();

        for (int i = 0; i < numTestCases; ++i) {
            int numSupporters = scanner.nextInt();
            int[] supporterRequests = new int[numSupporters];

            for (int j = 0; j < numSupporters; ++j) {
                supporterRequests[j] = scanner.nextInt();
            }

            int numStalls = scanner.nextInt();
            int[][] stalls = new int[numStalls][2];

            for (int j = 0; j < numStalls; ++j) {
                stalls[j][0] = scanner.nextInt();
                stalls[j][1] = scanner.nextInt();
            }

            int result = supportersWithItems(supporterRequests, numStalls, stalls);
            System.out.println(result);
        }
    }
}
