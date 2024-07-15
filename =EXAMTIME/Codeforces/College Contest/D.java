import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong(); 

        while (t-- > 0) {
            long n = scanner.nextLong();  
            long[] a = new long[(int) n];  

            for (long i = 0; i < n; i++) {
                a[(int) i] = scanner.nextLong();
            }

            long count = 0;
            Map<Long, Long> frequencyMap = new HashMap<>();

            for (long i = 0; i < n; i++) {
                long diff = a[(int) i] - i;

                count += frequencyMap.getOrDefault(diff, 0L);

                frequencyMap.put(diff, frequencyMap.getOrDefault(diff, 0L) + 1);
            }

            System.out.println(count);
        }
    }
}
