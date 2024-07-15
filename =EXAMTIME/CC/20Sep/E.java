import java.util.Scanner;

    import java.util.Scanner;

    public class E {
      
            public static int minimizeXORDifference(int A, int B) {
                int xorResult = A ^ B;
                int leftmostSetBit = 0;
        
                // Find the leftmost set bit position
                while (xorResult > 0) {
                    xorResult >>= 1;
                    leftmostSetBit++;
                }
        
                // Set all bits to the right of the leftmost set bit to 1 in X
                int X = (1 << leftmostSetBit) - 1;
        
                return X;
            }
        
            public static void main(String[] args) {
                int A = 5;
                int B = 1;
                int X = minimizeXORDifference(A, B);
                System.out.println(X);  // This will give you the value of X that minimizes the difference.
            }
        }
        