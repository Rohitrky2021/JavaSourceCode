import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            String firstRow = scanner.nextLine();
            String secondRow = scanner.nextLine();
            
            StringBuilder path = new StringBuilder();
            int count = 0;
            
            int i = 0, j = 0;
            while (i < n && j < n) {
                if (firstRow.charAt(j) == '0' && secondRow.charAt(j) == '0') {
                    path.append("0");
                    if (i == 0) i++;
                    else j++;
                } else if (firstRow.charAt(j) == '1' && secondRow.charAt(j) == '1') {
                    if (i == 0) {
                        path.append("1");
                        j++;
                    } else {
                        path.append("1");
                        i++;
                    }
                } else {
                    path.append("1");
                    if (firstRow.charAt(j) == '1') i++;
                    else j++;
                }
            }
            
            while (i < n) {
                path.append("0");
                i++;
            }
            
            while (j < n) {
                path.append("0");
                j++;
            }
            
            System.out.println(path);
            
            // Counting number of paths
            i = 0;
            j = 0;
            while (i < n && j < n) {
                if ((firstRow.charAt(j) == '0' && secondRow.charAt(j) == '0') ||
                        (firstRow.charAt(j) == '1' && secondRow.charAt(j) == '1' && i == 1)) {
                    if (i == 0) i++;
                    else j++;
                } else {
                    if (i == 0 && firstRow.charAt(j) == '1') count++;
                    else if (i == 1 && secondRow.charAt(j) == '1') count++;
                    
                    if (firstRow.charAt(j) == '1') i++;
                    else j++;
                }
            }
            
            System.out.println(count + 1); // Adding 1 as the path we found also counts
        }
        
        scanner.close();
    }
}
