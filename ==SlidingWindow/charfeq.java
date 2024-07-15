public class charfeq {
    public int equalSubstring(String s, int k) {
        char[] sa = s.toCharArray();
        int[] charCount = new int[26];  

        int max = 0;
        int start = 0;
 

         for (int end = 0; end < sa.length; end++) {

            charCount[sa[start] - 'a']++;

             while (!isValid(charCount, k) && start<sa.length-1) {
                charCount[sa[end] - 'a']--;

                start++;
            }
            max++;

 
        }
        if (isValid(charCount, k))
            max++;

        return max;
    }

    private boolean isValid(int[] charCount, int k) {
        for (int count : charCount) {
            if (count > k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        charfeq solution = new charfeq();
        String s = "ceccca";
        int k = 3;
        System.out.println(solution.equalSubstring(s, k)); // Output should be 6
    }
}
