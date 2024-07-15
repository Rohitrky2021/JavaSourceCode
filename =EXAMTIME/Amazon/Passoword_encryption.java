 


public class Passoword_encryption {
    public static String findEncryptedPassword(String password) {
        int[] arr = new int[26];

        for (char c : password.toCharArray()) {
            arr[c - 'a']++;
        }

        StringBuilder l = new StringBuilder();
        StringBuilder m = new StringBuilder();
        StringBuilder r = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;
            char ch = (char) (i + 'a');
            if (arr[i] % 2 != 0) {
                m.append(ch);
                arr[i]--;
            }

            for (int j = 0; j < arr[i] / 2; j++) {
                l.append(ch);
                r.insert(0, ch);
            }
        }

        return l.toString() + m.toString() + r.toString();
    }

    public static void main(String[] args) {
        // Test the method with a sample password
        String password = "babab";
        System.out.println(findEncryptedPassword(password)); // Output will depend on the input password
    }
}


// string findEncryptedPassword(const string& password) {
//     int arr[26] = {0};

//     for (char c : password) {
//         arr[c - 'a']++;
//     }

//     string l, m, r;
//     l = m = r = "";

//     for (int i = 0; i < 26; i++) {
//         if (arr[i] == 0) continue;
//         char ch = static_cast<char>(i + 'a');
//         if (arr[i] % 2 != 0) {
//             m = string(1, ch);
//             arr[i]--;
//         }

//         for (int j = 0; j < arr[i] / 2; j++) {
//             l += ch;
//             r = ch + r;
//         }
//     }

//     return l + m + r;
// }