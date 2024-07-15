import java.util.*;

public class DSU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }

    private static void solve(Scanner sc) {
        int n = sc.nextInt();

        int[][] arr = new int[n][];

        Set<Integer>[] list = new HashSet[51];

        for (int i = 1; i <= 50; ++i) {
            list[i] = new HashSet<>();
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            arr[i] = readArray(sc.nextInt());

            for (int num : arr[i]) {
                set.add(num);
                list[num].add(i);
            }
        }

        int size = set.size();

        set.clear();

        int result = 0;

        for (int i = 1; i <= 50; ++i) {
            if (list[i].size() == 0)
                continue;

            set.clear();
            for (int j = 0; j < n; ++j) {
                if (list[i].contains(j))
                    continue;

                for (int num : arr[j]) {
                    set.add(num);
                }
            }

            result = Math.max(result, set.size());
        }

        System.out.println(result);
    }

    private static int[] readArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }
}


// private void solve(int t) {
//     int n = sc.nextInt();
    
//     int [][] arr = new int [n][];
    
    
//     Set<Integer> [] list = new Set [51];
    
//     for (int i = 1; i <= 50; ++i) {
//         list[i] = new HashSet<>();
//     }
    
//     Set<Integer> set = new HashSet<>();
    
//     for (int i = 0; i < n; ++i) {
//         arr[i] = sc.readArray(sc.nextInt());
        
//         for (int num : arr[i]) {
//             set.add(num);
//             list[num].add(i);
//         }
//     }
    
//     int size = set.size();
    
    
//     set.clear();
    
//     int result = 0;
    
//     for (int i = 1; i <= 50; ++i) {
//         if (list[i].size() == 0)
//             continue;
        
//         set.clear();
//         for (int j = 0; j < n; ++j) {
//             if (list[i].contains(j))
//                 continue;
            
//             for (int num : arr[j]) {
//                 set.add(num);
//             }
//         }
        
//         result = Math.max(result, set.size());
//     }
    
//     out.println(result);
// }
// }