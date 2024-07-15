 
public class B {
    public static void main(String[] args) {
        B solution = new B();
        int[] A = {1, 3, 5};
        int[] B = {1, 2, 3};
        int result = solve(A, B);
        System.out.println("Minimum sum: " + result);
    }


    public static int solve(int[] A, int[] B) {
        int N = A.length;
        int minSum = Integer.MAX_VALUE;
        
        for (int i=0; i<N; i++) {
            int sum=0;
            int minLeftCost = Integer.MAX_VALUE;

            for  (int j=i-1; j>=0; j--) {
                if (A[j]<A[i]) {
                    if (B[j]<minLeftCost) {
                        minLeftCost = B[j];
                    }
                }
            }
            int minRightCost = Integer.MAX_VALUE;

            for  (int j=i+1; j<N; j++) {
                if (A[j]>A[i]) {
                    if (B[j]<minRightCost) {
                        minRightCost = B[j];
                    }
                }
            }
            
            if (minLeftCost!=Integer.MAX_VALUE && minRightCost!=Integer.MAX_VALUE) {
                sum = B[i]+minLeftCost+minRightCost;
                if (sum<minSum) {
                    minSum=sum;
                }
            }
        }

        if (minSum==Integer.MAX_VALUE) return -1;

        return minSum;
    }
}
