import java.util.Scanner;

public class E {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            long z = scanner.nextLong();
            long k = scanner.nextLong();
            System.out.println(maxDistinctLocations(x, y, z, k));
        }
    }

    private static long maxDistinctLocations(long x, long y, long z, long k) {
        long maxLocations = 0;

        for (long a = 1; a <= x; a++) {
            if (k % a != 0) continue;
            long remainingVolume = k / a;

            for (long b = 1; b <= y; b++) {
                if (remainingVolume % b != 0) continue;
                long c = remainingVolume / b;

                if (c > z || c <= 0) continue;

                long locations = (x - a + 1) * (y - b + 1) * (z - c + 1);
                maxLocations = Math.max(maxLocations, locations);
            }
        }

        return maxLocations;
    }
}
