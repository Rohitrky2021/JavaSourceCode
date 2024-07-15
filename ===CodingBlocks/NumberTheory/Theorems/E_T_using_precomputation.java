 
public class E_T_using_precomputation {
    static void calculatePhi(int n) {
        int[] phi = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            phi[i] = i; // phi[1] is 0
        }

        for (int i = 2; i <= n; i++) {
            if (phi[i] == i) {
                for (int j = i; j <= n; j += i) {
                    phi[j] = (phi[j] / i) * (i - 1);
                }
            }
        }

        // Print or use the phi array as needed
        for (int i = 1; i <= n; i++) {
            System.out.println("phi[" + i + "] = " + phi[i]);
        }
    }

    public static void main(String[] args) {
        int n = 18; // Replace with your desired value of n
        calculatePhi(n);
    }
}
