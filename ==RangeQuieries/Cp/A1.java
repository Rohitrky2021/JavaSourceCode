
    import java.util.ArrayList;
    import java.util.Scanner;
    
    public class A1 {
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading n
    
            ArrayList<Integer> sequence = new ArrayList<>();
            double sum = 0;
    
            for (int i = 0; i < n; i++) {
                String[] operation = scanner.nextLine().split(" ");
    
                int type = Integer.parseInt(operation[0]);
                int a = Integer.parseInt(operation[1]);
                int x = Integer.parseInt(operation[2]);
                int k = Integer.parseInt(operation[1]);
    
                if (type == 1) {
    
                    for (int j = 0; j < a; j++) {
                        sum += x;
                        sequence.set(j, sequence.get(j) + x);
                    }
                } else if (type == 2) {
                    sequence.add(k);
                    sum += k;
                } else {
                    int lastElement = sequence.remove(sequence.size() - 1);
                    sum -= lastElement;
    
                    // If there are still elements in the sequence, adjust sum
                    if (!sequence.isEmpty()) {
                        sum -= lastElement;
                    }
                }
    
                // Calculate and print the average
                double average = sequence.isEmpty() ? 0 : sum / sequence.size();
                System.out.println(average);
            }
    
            scanner.close();
        }
    }
    