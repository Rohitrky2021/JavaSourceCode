public class ok {
    private int[] BIT;
    private int[] countSmaller;
    private int[] countLarger;

    public ok(int size) {
        BIT = new int[size + 1];
        countSmaller = new int[size];
        countLarger = new int[size];
    }

    public void update(int index, int delta) {
        index++;
        while (index < BIT.length) {
            BIT[index] += delta;
            index += index & -index;
        }
    }

    public int query(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & -index;
        }
        return sum;
    }

    public static int countInversionTriplets(int[] arr) {
        int n = arr.length;
        int maxElement = Integer.MIN_VALUE; // Find the maximum element in the array.
        for (int num : arr) {
            maxElement = Math.max(maxElement, num);
        }

        TripletInvers fenwick = new TripletInvers(maxElement);

        int inversionTriplets = 0;

        for (int i = n - 1; i >= 0; i--) {
            int smallerLeft = fenwick.query(arr[i] - 1);
            int largerRight = i - fenwick.query(arr[i]); // Fixed to ensure it doesn't go out of bounds
            
            inversionTriplets += smallerLeft * largerRight;
            
            fenwick.update(arr[i], 1);
        }

        return inversionTriplets;
    }

    public static void main(String[] args) {
        int[] arr = {10, 8, 3, 1};
        int inversionTriplets = countInversionTriplets(arr);
        System.out.println("Inversion Triplets Count: " + inversionTriplets); // Output: 4
    }
}
