public class sum {
    // public class DigitDP {
        // public class DigitDP {
            public int digitDP(String ss) {
                int n = ss.length();
                int[][][] dp = new int[n + 1][2][200];
        
                // Empty suffixes having sum = 0
                dp[n][0][0] = 1;
                dp[n][1][0] = 1;
        
                for (int i = n - 1; i >= 0; i--) {
                    for (int tight = 0; tight < 2; tight++) {
                        for (int sum = 0; sum < 200; sum++) {
                            if (tight == 1) {
                                for (int d = 0; d <= ss.charAt(i) - '0'; d++) {
                                    if (sum - d >= 0) {
                                        if (d == ss.charAt(i) - '0') {
                                            dp[i][1][sum] += dp[i + 1][1][sum - d];
                                        } else {
                                            dp[i][1][sum] += dp[i + 1][0][sum - d];
                                        }
                                    }
                                }
                            } else {
                                for (int d = 0; d < 10; d++) {
                                    if (sum - d >= 0) {
                                        dp[i][0][sum] += dp[i + 1][0][sum - d];
                                    }
                                }
                            }
                        }
                    }
                }
        
                int ans = 0;
                for (int i = 0; i < 200; i++) {
                    if (isPrime(i)) {
                        ans += dp[0][1][i];
                    }
                }
                return ans;
            }
        
            private boolean isPrime(int num) {
                if (num <= 1) {
                    return false;
                }
                for (int i = 2; i * i <= num; i++) {
                    if (num % i == 0) {
                        return false;
                    }
                }
                return true;
            }
        
            public static void main(String[] args) {
                sum digitDP = new sum();
                String input = "9"; // Replace with your input
                int result = digitDP.digitDP(input);
                System.out.println("Result: " + result);
            }
        }
        
        // https://www.spoj.com/problems/GONE/
    

        // GONE - G-One Numbers
        // #dynamic-programming
        // The War of Evil vs Good continues and Ra-One and G-One continue to be on respective sides.
        
        // After saving all the cities with Ra-One Numbers G-One realised that some cities whose population is a "G-One Number" can be easy target for Ra-One.
        
        // A G-One number is a number sum of whose digits is a prime number
        
        // For example 12 .. sum = 1+2 = 3 ... 3 is a prime number.
        
        // G-One wants to find out all the populations which can be g-One numbers....
        
        // Can You help him.?
        
        // You will be given the range of population and you have to tell him how many in this range are G-One Numbers.
        
        // Input
        // first line has number 'c' indicating the number of ranges.
        
        // 'c' lines follow and contain two numbers ... 'f' and 't' inclusive.
        
        // Output
        // Print a single line per case giving the number of populations which are G-One numbers.
        
        // Example
        // Input:
        // 3
        // 10 19
        // 1 9
        // 20 29
        
        // Output:
        // 4
        // 4
        // 5
        // Note: c will be less than 100
        // t and f will be less than 10^8 inclusive