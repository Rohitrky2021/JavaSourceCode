
public class c1 {

    public static void main(String[] args) {
        // Example usage
        int[] v =  {300,200,100,200,500};  // Replace with your actual array
        int t = 700;  // Replace with your actual target value

        int result = d(v, t);
        System.out.println("First day to reach or exceed the target: " + result);
    }

    static int d(int[] v, int t) {
        int tv = 0;
        for (int i = 0; i < v.length; i++) {
            tv += v[i];
            if (tv >= t) {
                return i;
            }
        }
        return -1;
    }
}

// public class c12 {

//     public static void main(String[] args) {
//         // Example usage
//         int[] visits = {300,200,100,200,500};  // Replace with your actual array
//         int target = 700;  // Replace with your actual target value

//         int result = firstDay(visits, target);
//         System.out.println("First day to reach or exceed the target: " + result);
//     }

//     static int firstDay(int[] visits, int target) {
//         int totalVisits = 0;
//         for (int i = 0; i < visits.length; i++) {
//             totalVisits += visits[i];
//             if (totalVisits >= target) {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

