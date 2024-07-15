public class B {
    public static long minSumk(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int countZeros1 = 0, countZeros2 = 0;

        // Calculate sums and count zeros in each array
        for (int num : nums1) {
            sum1 += num;
            if (num == 0)
                countZeros1++;
        }

        for (int num : nums2) {
            sum2 += num;
            if (num == 0)
                countZeros2++;
        }

        long targetSum = (sum1 + sum2) / 2;

        // if (Math.abs(targetSum - sum1) > countZeros1 || Math.abs(targetSum - sum2) > countZeros2) {
        //     return -1; // It's impossible to make the sums equal
        // }

        // Replace zeros to make sums equal to targetSum
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                nums1[i] = (int) ((targetSum - sum1) / countZeros1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0) {
                nums2[i] = (int) ((targetSum - sum2) / countZeros2);
            }
        }
        long hero=Math.min(countZeros1, countZeros2);
        long maxx=Math.max(sum1, sum2);


        return Math.min(maxx+hero, 60);
    }

    public static long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zeros1 = 0, zeros2 = 0;

        for (int num : nums1) {
            sum1 += num;
            if (num == 0) {
                zeros1++;
            }
        }

        for (int num : nums2) {
            sum2 += num;
            if (num == 0) {
                zeros2++;
            }
        }

        long diff = Math.abs(sum1 - sum2);
        System.out.println(diff);

        // If the difference is odd or if there are more zeros in one array than needed
        // to balance the sum,
        // it's impossible to make the sums equal.
        if (diff != 0 && (zeros1 == 0 || zeros2 == 0)) {
            return -1;
        }
        long hero=Math.min(zeros1, zeros2);
        long maxx=Math.max(sum1, sum2);

        // Calculate the minimum value to replace each zero.
        long minReplacementValue = diff / 2;

        return maxx+hero;
    }
     
        public long minSum(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            long sum1 = 0, sum2 = 0;
            long zeros1 = 0, zeros2 = 0;
    
            for (int i = 0; i < n; i++) {
                sum1 += nums1[i];
                if (nums1[i] != 0) {
                    zeros1++;
                }
            }
    
            for (int i = 0; i < m; i++) {
                sum2 += nums2[i];
                if (nums2[i] != 0) {
                    zeros2++;
                }
            }
    
            if (sum1 == sum2) {
                return sum1;
            } else if (sum1 < sum2) {
                if (zeros1 > 0) {
                    return sum2;
                } else {
                    return -1;
                }
            } else {
                if (zeros2 > 0) {
                    return sum1;
                } else {
                    return -1;
                }
            }
        }
    }
    public class Solution {
        public long minSum(int[] nums1, int[] nums2) {
            int length1 = nums1.length;
            int length2 = nums2.length;
            long sum1 = 0, sum2 = 0;
            long zeros1 = 0, zeros2 = 0;
    
            int index1 = 0;
            while (index1 < length1) {
                sum1 += nums1[index1];
                if (nums1[index1] == 0) {
                    sum1++;
                    zeros1++;
                }
                index1++;
            }
            isSorted(nums1);
            isSorted(nums2);
    
            int index2 = 0;
            while (index2 < length2) {
                sum2 += nums2[index2];
                if (nums2[index2] == 0) {
                    sum2++;
                    zeros2++;
                }
                index2++;
            }
            isSorted(nums1);
            isSorted(nums2);
    
            if (sum1 == sum2) {
                return sum1;
            } else if (sum1 < sum2) {
                if (zeros1 > 0) {
                    return sum2;
                } else {
                    return -1;
                }
            } else {
                if (zeros2 > 0) {
                    return sum1;
                } else {
                    return -1;
                }
            }
        }
    }
    
        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    

    public static long minSumm(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        int countZeros1 = 0;
        int countZeros2 = 0;

        for (int num : nums1) {
            sum1 += num;
            if (num == 0) {
                countZeros1++;
            }
        }

        for (int num : nums2) {
            sum2 += num;
            if (num == 0) {
                countZeros2++;
            }
        }

        long diff = Math.abs(sum1 - sum2);

        // if (diff % 2 != 0) {
        // return -1;
        // }

        long targetDiff = diff / 2;

        int count1 = 0;
        int count2 = 0;

        if (sum1 > sum2) {
            count1 = countZeros1;
            count2 = countZeros2;
            targetDiff = -targetDiff;
        } else {
            count1 = countZeros2;
            count2 = countZeros1;
        }

        long minReplacementValue = Math.max(targetDiff - (sum1 - sum2) / count1, targetDiff + (sum1 - sum2) / count2);

        if (countZeros1 == 0 && countZeros2 == 0 && sum1 != sum2) {
            return -1;
        }

        return targetDiff + minReplacementValue;
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 2, 0, 1, 0 };
        int[] nums2 = { 6, 5, 0 };
        long result = minSum(nums1, nums2);
        System.out.println("Output: " + result);
    }
}
