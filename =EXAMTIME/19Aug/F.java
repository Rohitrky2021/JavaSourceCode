import java.util.*;



public class F {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int t = scanner.nextInt(); // number of test cases
       
       while (t-- > 0) {
           int n = scanner.nextInt(); // length of the array
           int[] a = new int[n];
           
           for (int i = 0; i < n; i++) {
               a[i] = scanner.nextInt();
           }
           
           int maxOperations = 0;
           int i = 0;
           
           while (i < n - 1) {
               if (a[i] == i + 1  ) {
                   maxOperations++;
                   i += 2; // Skip the current pair ai and ai+1
               } else if(a[i] == i + 1 && a[i+1] != i + 2){
                maxOperations++;
               }
               else {
                   i++; // Move to the next element
               }
           }
           
           System.out.println(maxOperations);
       }
       
       scanner.close();
   }
}



 class Fs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = scanner.nextInt(); // length of the array
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            
            int operations = 0;
            int i = 0;
            while (i < n - 1) {
                if (a[i] == i + 1) {
                    // Perform the operation
                    operations++;
                    // Remove a[i] and a[i+1]
                    for (int j = i; j < n - 2; j++) {
                        a[j] = a[j + 2];
                    }
                    n -= 2; // Reduce the length of the array
                    i = Math.max(0, i - 1); // Reset i to previous or stay at 0
                } else {
                    i++;
                }
            }
            
            System.out.println(operations);
        }
    }
}

 class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        
        while (t-- > 0) {
            int n = scanner.nextInt(); // length of the array
            int[] a = new int[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            
            int operations = 0;
            boolean changed = true;
            
            while (changed) {
                changed = false;
                
                for (int i = 0; i < n - 1; i++) {
                    if (a[i] == i + 1) {
                        operations++;
                        // Remove a[i] and a[i+1] by shifting remaining elements
                        for (int j = i; j < n - 2; j++) {
                            a[j] = a[j + 2];
                        }
                        n -= 2; // reduce array length
                        changed = true;
                        break; // restart from beginning of the array
                    }
                }
            }
            
            System.out.println(operations);
        }
        
        scanner.close();
    }
}
