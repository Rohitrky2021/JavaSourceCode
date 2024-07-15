 
public class ReverseString_binary {
    public static int solution(String s) {
        final int n = s.length();
        int r = 0;
        for (int i = n - 1, j = 0; i >= 0 && j < n; ++j) {
            if (s.charAt(i) == s.charAt(j)) {
                --i;
                ++r;
            }
        }
        return n - r;
    }

    public static void main(String[] args) {
        // Test the method with a sample string
        String testString = "00110101";
        System.out.println(solution(testString)); // Output will depend on the input string
    }
}



// AMazon Grayscale AWS 


// int solution(const string &s) {
//         const int n = s.length();
//         int r = 0;
//         for (int i = n - 1, j = 0; i >= 0 && j < n; ++j) {
//             if (s[i] == s[j]) {
//                 --i;
//                 ++r;
//             }
//         }
//         return n - r;
//     }
    
    // Amazon ✅