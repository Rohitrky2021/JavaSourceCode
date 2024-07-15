 

import java.util.HashMap;
import java.util.Map;

public class Machine_learning_Amaz {
    public static long getkRepValue(String userHistory, long k) {
        long n = userHistory.length();
        Map<Character, Long> count = new HashMap<>();
        long left = 0, right = 0, ans = 0;

        while (right < n) {
            char currentChar = userHistory.charAt((int) right);
            count.put(currentChar, count.getOrDefault(currentChar, 0L) + 1);
            while (count.getOrDefault(currentChar, 0L) >= k && left <= right) {
                ans += n - right;
                char leftChar = userHistory.charAt((int) left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            }
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        String userHistory = "ababa";
        long k = 2;
        System.out.println(getkRepValue(userHistory, k));
    }
}


// 'OR the User_history '

// #include <iostream>
// #include <string>
// #include <unordered_map>

// using namespace std;

// long getkRepValue(string user_history, long k) {
//     long n = user_history.size();
//     unordered_map<char, long> count;
//     long left = 0, right = 0, ans = 0;

//     while (right < n) {
//         count[user_history[right]]++;
//         while (count[user_history[right]] >= k && left <= right) {
//             ans += n - right;
//             count[user_history[left]]--;
//             left++;
//         }
//         right++;
//     }

//     return ans;
// }  
// // Machine learning Amazon


// #include <iostream>
// #include <string>
// #include <unordered_map>

// using namespace std;

// long getkRepValue(string user_history, long k) {
//     long n = user_history.size();
//     unordered_map<char, long> count;
//     long left = 0, right = 0, ans = 0;

//     while (right < n) {
//         count[user_history[right]]++;
//         while (count[user_history[right]] >= k && left <= right) {
//             ans += n - right;
//             count[user_history[left]]--;
//             left++;
//         }
//         right++;
//     }

//     return ans;
// }  

// Machine learning Amazon ✅