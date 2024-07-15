import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ap {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java a <file_path>");
            return;
        }
        String file_path = args[1];
        Solution solution = new Solution();
        // Start time
        long start_time = System.nanoTime();
        
         
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        scanner.nextLine();  
        
        for (int i = 0; t > 0; i++) {
            String s = scanner.nextLine();
            String result =solution.checkString(s);  
            System.out.println(result);
            t--;
        }
        
        // End time
        long end_time = System.nanoTime();
        scanner.close();
        double execution_time = (end_time - start_time) / 1e9;
        
        try (FileWriter writer = new FileWriter(file_path)) {
            writer.write("*-SUBMISSION::USER_CODE_FUNCTION_EXECUTION_TIME_KEY-* " + execution_time);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}

class Solution {
 
public  String checkString(String s) {
    if (s.equalsIgnoreCase("YES")) {
        return "YES";
    } else {
        return "NO";
    }
}
}
