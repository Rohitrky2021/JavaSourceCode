public class Normal_Subsequnece {
  // https://leetcode.com/problems/is-subsequence/?envType=daily-question&envId=2023-09-22

  // public boolean isSubsequence(String s, String t) {
  // int sIndex = 0;

  // for (int tIndex = 0; tIndex < t.length() && sIndex < s.length(); tIndex++) {
  // if (s.charAt(sIndex) == t.charAt(tIndex)) {
  // sIndex++;
  // }
  // }

  // return sIndex == s.length();
  // }

  // }

  class Solution {
    public boolean isSubsequence(String s, String t) {
      // 1 ms code beat 53%
      // int si=0;
      // if(s.length()<1)
      // return true;
      // for(int i=0;i<t.length();i++){
      // if(s.charAt(si)==t.charAt(i))
      // si++;

      // if(si==s.length())
      // return true;
      // }

      // 1 ms beat 100
      int i = 0, j = 0;
      int m = s.length();
      int n = t.length();
      char ss[] = s.toCharArray();
      char tt[] = t.toCharArray();

      if (m < 1)
        return true;

      while (i < n) {
        if (tt[i] == ss[j]) {
          j++;
        }
        i++;

        if (j == m)
          return true;
      }

      return false;
    }
  }

class Solution {
  public boolean isSubsequence(String s, String t) {
    if (s.isEmpty())
      return true;

    int i = 0;
    for (final char c : t.toCharArray())
      if (s.charAt(i) == c && ++i == s.length())
        return true;

    return false;
  }
}

//  M2--> Same  as Above 

public class A_chat_room_Subsequence {
    public static void main(String[] args) {
        String check = "hello";
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int j = 0; // Initialize a pointer for the 'hello' string

        // Iterate through the typed word 's'
        for (char letter : s.toCharArray()) {
            if (letter == check.charAt(j)) {
                j++; // Move to the next character in 'hello'

                if (j == 5) {
                    System.out.println("YES");
                    return; // Exit the loop since we found 'hello'
                }
            }
        }

        // If we didn't find 'hello', print "NO"
        System.out.println("NO");
    }
}
