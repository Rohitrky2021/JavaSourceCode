import java.util.ArrayList;

class Alixa_virtualAI_Temp {
    public int solve(ArrayList<Integer> tc) {
        int n = tc.size();
        ArrayList<Integer> p = new ArrayList<>(n);
        ArrayList<Integer> s = new ArrayList<>(n);

        p.add(tc.get(0));
        for (int i = 1; i < n; ++i) {
            p.add(p.get(i - 1) + tc.get(i));
        }

        s.add(tc.get(n - 1));
        for (int i = n - 2; i >= 0; --i) {
            s.add(s.get(n - 2 - i) + tc.get(i));
        }

        int m = Math.max(p.get(0), s.get(0));
        for (int i = 1; i < n; ++i) {
            m = Math.max(m, Math.max(p.get(i), s.get(i)));
        }

        return m;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testInput = new ArrayList<>();
        testInput.add(-1);
        testInput.add(2);
        testInput.add(3);
        // testInput.add(1);
        // testInput.add(2);
        
        Alixa_virtualAI_Temp solution = new Alixa_virtualAI_Temp();
        int result = solution.solve(testInput);
        System.out.println("Result: " + result);
    }
}




// int solve(vector<int> tc) {
//         int n = tc.size();
//         vector<int> p(n), s(n);
    
//         p[0] = tc[0];
//         for (int i = 1; i < n; ++i) {
//             p[i] = p[i - 1] + tc[i];
//         }
    
//         s[n - 1] = tc[n - 1];
//         for (int i = n - 2; i >= 0; --i) {
//             s[i] = s[i + 1] + tc[i];
//         }
    
//         int m = max(p[0], s[0]);
//         for (int i = 1; i < n; ++i) {
//             m = max(m, max(p[i], s[i]));
//         }
    
//         return m;
//     }
    
//     Amazon ✅

class Alixa_virtualAI_Temp2 {
    public int solve(int[] tc) {
        int n = tc.length;
        int[] p = new int[n];
        int[] s = new int[n];

        p[0] = tc[0];
        for (int i = 1; i < n; ++i) {
            p[i] = p[i - 1] + tc[i];
        }

        s[n - 1] = tc[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            s[i] = s[i + 1] + tc[i];
        }

        int m = Math.max(p[0], s[0]);
        for (int i = 1; i < n; ++i) {
            m = Math.max(m, Math.max(p[i], s[i]));
        }

        return m;
    }

    public static void main(String[] args) {
        int[] testInput = {2, 3, 7, 1, 2};
        
        Alixa_virtualAI_Temp2 solution = new Alixa_virtualAI_Temp2();
        int result = solution.solve(testInput);
        System.out.println("Result: " + result);
    }
}
