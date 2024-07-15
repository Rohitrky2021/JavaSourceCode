import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class D {
    static FastReader sc = new FastReader();

    public static PrintWriter pw = new PrintWriter(System.out);

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

    public static <T> void print(T num) {
        if (num instanceof int[]) {
            pw.println(Arrays.toString((int[]) num));
        } else if (num instanceof long[]) {
            pw.println(Arrays.toString((long[]) num));
        } else if (num instanceof char[]) {
            pw.println(Arrays.toString((char[]) num));
        } else if (num instanceof String[]) {
            pw.println(Arrays.toString((String[]) num));
        } else if (num instanceof double[]) {
            pw.println(Arrays.toString((double[]) num));
        } else if (num instanceof boolean[]) {
            pw.println(Arrays.toString((boolean[]) num));
        } else {
            pw.println(num);
        }
    }

    public static void printMultiple(Object... inputs) {
        for (Object input : inputs) {
            pw.print(input + " ");
        }
        pw.println();
    }

    static <T> void printMap(Map<T, List<T>> mp) {
        for (var e : mp.entrySet()) {
            printMultiple(e.getKey(), "->", e.getValue());
        }
    }

    static <T> void printSet(Set<T> set) {
        for (var e : set) {
            print(e);
        }
    }

    public static int[] intArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    public static long[] longArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        return arr;
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            if (n % 4 == 0 && k % 2 == 1) {
                print(-1);
                continue;
            }

            if (n % 4 != 0 && k % 2 == 0) {
                print(-1);
                continue;
            }

            int limit = 99998;
            int min = (3 * n) / 2;
            if (k < min) {
                print(-1);
            } else {
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = i % 2 == 0 ? 2 : 1;
                }

                int sum = min;
                for (int i = 0; i < n; i++) {
                    if (k == sum)
                        break;
                    int remaining = k - sum;
                    arr[i] += Math.min(limit, remaining);
                    sum += Math.min(limit, remaining);
                }

                if (sum == k) {
                    for (int i : arr) {
                        pw.print(i + " ");
                    }
                    print("");
                } else {
                    print(-1);
                }
            }

        }
        pw.close();
    }
}
