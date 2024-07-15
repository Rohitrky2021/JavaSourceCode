package BitwiseOperators;

public class FindUnique {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4, 5, 4, 3, 2, 1 };
        System.out.println(findUniqueUsingXOR(arr));
    }

    // The array contains duplicates of all its numbers, except for one number,
    // find the unique element

    static int findUniqueUsingXOR(int[] arr) {
        int unique = 0;

        for (int n : arr) {
            unique ^= n; // unique = nuique ^ n
        }

        return unique;
    }
}
