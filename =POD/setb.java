public class setb {

    static void findNumbers(int L, int R) {
        int count=0;
        for (int i = L; i <= R; i++) {
            int setBits = Integer.bitCount(i);
            if (isPerfectSquare(setBits)) {
                // System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean isPerfectSquare(int num) {
        return Math.sqrt(num) % 1 == 0;
    }

    public static void main(String[] args) {
        int L = 1;
        int R = 20;

        findNumbers(L, R);
    }
}
