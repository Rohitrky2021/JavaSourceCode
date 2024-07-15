
public class FuelStation_MAin {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
            Integer[] gas = A.toArray(new Integer[A.size()]);
            Integer[] cost = B.toArray(new Integer[A.size()]);
            
            int n = gas.length;
            int sum = 0;  // Track the current sum of gas - cost
            int total = 0;  // Track the total sum of gas - cost
            int start = 0;  // The potential starting point
    
            for (int i = 0; i < n; i++) {
                int diff = gas[i] - cost[i];
                sum += diff;
                total += diff;
    
                // If the sum becomes negative, we reset it and try the next station as the starting point.
                if (sum < 0) {
                    sum = 0;
                    start = i + 1;
                }
            }
    
            // If the total sum is non-negative, there exists a valid starting point.
            if (total >= 0) {
                return start;
            } else {
                return -1;  // If the total sum is negative, it's impossible to complete the circuit.
            }
            
        }
    }
    
