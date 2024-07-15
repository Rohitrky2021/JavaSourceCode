 

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;



public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main <file_path>");
            return;
        }
        String file_path = args[1];
        
        //input start
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        // input end
        
        
        //Start time
        long start_time = System.nanoTime();
        
        // Creating object of the solution class
        Solution sol = new Solution();
        int[] dist = sol.countOfPairs(n, x, y);
        
        long end_time = System.nanoTime();
        scanner.close();
        double execution_time = (end_time - start_time) / 1e9;
        
        
        // Output printing
        System.out.println(Arrays.toString(dist));
        System.out.println();
        
        
        
        try (FileWriter writer = new FileWriter(file_path)) {
            writer.write("*-SUBMISSION::USER_CODE_FUNCTION_EXECUTION_TIME_KEY-* " + execution_time);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
 

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main <file_path>");
            return;
        }
        String file_path = args[1];
        
        //input start
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        // input end
        
        
        //Start time
        long start_time = System.nanoTime();
        
        // Creating object of the solution class
        Solution sol = new Solution();
        int[] dist = sol.countOfPairs(n, x, y);
        
        long end_time = System.nanoTime();
        scanner.close();
        double execution_time = (end_time - start_time) / 1e9;
        
        
        // Output printing
        System.out.println(Arrays.toString(dist));
        System.out.println();
        
        
        
        try (FileWriter writer = new FileWriter(file_path)) {
            writer.write("*-SUBMISSION::USER_CODE_FUNCTION_EXECUTION_TIME_KEY-* " + execution_time);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
 