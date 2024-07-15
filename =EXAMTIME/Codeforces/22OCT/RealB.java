import java.util.Scanner;
import java.util.ArrayList;
public class RealB {
    
    // public class Main {
    
        public static ArrayList<Integer> computeSwaps(int n, String binaryString) {
            String reversedString = new StringBuilder(binaryString).reverse().toString();
            int zeroCount = 0;
            ArrayList<Integer> zeroPositions = new ArrayList<>();
            int[] prefixSums = new int[n];
    
            for (int i = 0; i < n; i++) {
                if (reversedString.charAt(i) == '0') {
                    zeroCount++;
                    zeroPositions.add(i + 1);
                }
            }
    
            int index = 1;
            int back = 0;
    
            for (int i = 0; i < zeroPositions.size(); i++) {
                prefixSums[i] = zeroPositions.get(i) - index + back;
                back += zeroPositions.get(i) - index;
                index++;
            }
    
            ArrayList<Integer> results = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (zeroCount < i) {
                    results.add(-1);
                } else {
                    results.add(prefixSums[i - 1]);
                }
            }
    
            return results;
        }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int numTests = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
    
            for (int t = 0; t < numTests; t++) {
                int n = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                String binaryStr = scanner.nextLine().trim();
                ArrayList<Integer> results = computeSwaps(n, binaryStr);
                System.out.println(String.join(" ", results.stream().map(Object::toString).toArray(String[]::new)));
            }
        }
     
    }
    