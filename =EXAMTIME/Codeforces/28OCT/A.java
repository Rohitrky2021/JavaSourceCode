import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Length of the array a
            int[] array = new int[n];
            Map<Integer, Integer> frequencyMap = new HashMap<>();

            int i = 0;
            while (i < n) {
                array[i] = scanner.nextInt();
                frequencyMap.put(array[i], frequencyMap.getOrDefault(array[i], 0) + 1);
                i++;
            }
             

            if (frequencyMap.size() >= 3) {
                System.out.println("No");
            } else if (frequencyMap.size() == 1) {
                System.out.println("Yes");
            } else {
                int[] frequencyArray = new int[2];
                i = 0;
                for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                    frequencyArray[i] = entry.getValue();
                    i++;
                }
                if (Math.abs(frequencyArray[0] - frequencyArray[1]) >= 2) {
                    System.out.println("No");
                } else {
                    System.out.println("Yes");
                }
                 
            }
        }
       

        scanner.close();
    }
 
    
}
