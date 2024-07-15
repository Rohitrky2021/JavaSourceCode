import java.util.ArrayList;
import java.util.List;

public class Andrea_and_Maria {
    public static String winner(List<Integer> andrea, List<Integer> maria, String s) {
        int inc;
        if (s.equals("Even")) {
            inc = 0;
        } else {
            inc = 1;
        }
        int as = 0;
        int ms = 0;
        while (inc < andrea.size() || inc < maria.size()) {
            if (inc < andrea.size()) {
                as += andrea.get(inc);
            }
            if (inc < maria.size()) {
                ms += maria.get(inc);
            }
            inc += 2;
        }

        if (as == ms)
            return "Tie";
        else if (as > ms)
            return "Andrea";
        else
            return "Maria";
    }

    public static void main(String[] args) {
        List<Integer> andrea = new ArrayList<>();
        andrea.add(1);
        andrea.add(2);
        andrea.add(3);
        List<Integer> maria = new ArrayList<>();
        maria.add(2);
        maria.add(1);
        maria.add(3);

        String s = "Even";

        System.out.println(winner(andrea, maria, s)); // Output will depend on the input lists and the string s
    }
}


// #include <string>
// #include <vector>

// using namespace std;

// string winner(vector<int>& andrea, vector<int>& maria, string s) {
//     int inc;
//     if (s == "Even") {
//         inc = 0;
//     } else {
//         inc = 1;
//     }
//     int as = 0;
//     int ms = 0;
//     while (inc < andrea.size() || inc < maria.size()) {
//         if (inc < andrea.size()) {
//             as += andrea[inc];
//         }
//         if (inc < maria.size()) {
//             ms += maria[inc];
//         }
//         inc += 2;
//     }
    
//     if (as == ms)
//         return "Tie";
//     else if (as > ms)
//         return "Andrea";
//     else 
//         return "Maria";
// }