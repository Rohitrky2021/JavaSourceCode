import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class b0011 {

    private static void solveTC(int __) {


        //code start

        int n= scn.nextInt();
        String str = scn.next();

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for(int i=1; i<n; i++){
            if(str.charAt(i)!=str.charAt(i-1)){
                sb.append(str.charAt(i));
            }
        }

        int count = 0;
        int lo=0, hi=sb.length()-1;

        if (sb.length()<=1){
            print(0+"\n");
            return;
        }

        if (sb.charAt(lo)=='1'){
            count = sb.length()/2;
        }else {
            count = (sb.length()-1)/2;
        }

        print(count);

        //code end

        print("\n");
    }

    public static void main(String[] args) {
        scn = new Scanner();
        ans = new StringBuilder();
        int t = scn.nextInt();
//		int t = 1;

//        int limit=               ;
//        sieve(limit);

        /*
        try {
            System.setOut(new PrintStream(new File("file_i_o\\output.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
*/
        for (int i = 1; i <= t; i++) {
            solveTC(i);
        }
        System.out.print(ans);
    }
    //Stuff for prime start

    /**
     * sorting algos
     */
    private static void sort(int[] arr) {
        ArrayList<Integer> li = new ArrayList<>(arr.length);
        for (int ele : arr) li.add(ele);
        Collections.sort(li);
        for (int i = 0; i < li.size(); i++) {
            arr[i] = li.get(i);
        }
    }

    private static void sort(long[] arr) {
        ArrayList<Long> li = new ArrayList<>(arr.length);
        for (long ele : arr) li.add(ele);
        Collections.sort(li);
        for (int i = 0; i < li.size(); i++) {
            arr[i] = li.get(i);
        }
    }

    private static void sort(float[] arr) {
        ArrayList<Float> li = new ArrayList<>(arr.length);
        for (float ele : arr) li.add(ele);
        Collections.sort(li);
        for (int i = 0; i < li.size(); i++) {
            arr[i] = li.get(i);
        }
    }

    private static void sort(double[] arr) {
        ArrayList<Double> li = new ArrayList<>(arr.length);
        for (double ele : arr) li.add(ele);
        Collections.sort(li);
        for (int i = 0; i < li.size(); i++) {
            arr[i] = li.get(i);
            // Arrays.sort(arr);
        }
    }

    /**
     * List containing prime numbers <br>
     * <b>i<sup>th</sup></b> position contains <b>i<sup>th</sup></b> prime number <br>
     * 0th index is <b>null</b>
     */
    private static ArrayList<Integer> listOfPrimes;

    /**
     * query <b>i<sup>th</sup></b> element to get if its prime of not
     */
    private static boolean[] isPrime;

    /**
     * Performs Sieve of Erathosnesis and initialise isPrime array and listOfPrimes list
     *
     * @param limit the number till which sieve is to be performed
     */
    private static void sieve(int limit) {
        listOfPrimes = new ArrayList<>();
        listOfPrimes.add(null);
        boolean[] array = new boolean[limit + 1];

        Arrays.fill(array, true);
        array[0] = false;
        array[1] = false;

        for (int i = 2; i <= limit; i++) {
            if (array[i]) {
                for (long j = (long) i * i; j <= limit; j += i) {
                    array[(int) j] = false;
                }
            }
        }
        isPrime = array;
        for (int i = 0; i <= limit; i++) {
            if (array[i]) {
                listOfPrimes.add(i);
            }
        }
    }
    //stuff for prime end

    /**
     * Calculates the Least Common Multiple of two numbers
     *
     * @param a First number
     * @param b Second Number
     * @return Least Common Multiple of <b>a</b> and <b>b</b>
     */
    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    /**
     * Calculates the Greatest Common Divisor of two numbers
     *
     * @param a First number
     * @param b Second Number
     * @return Greatest Common Divisor of <b>a</b> and <b>b</b>
     */
    private static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static void print(Object obj) {
        ans.append(obj.toString());
    }


    static Scanner scn;
    static StringBuilder ans;

    //Fast Scanner
    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
/*
            try {
                br = new BufferedReader(new
                        InputStreamReader(new FileInputStream(new File("file_i_o\\input.txt"))));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
*/
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

        int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        Integer[] nextIntegerArray(int n) {
            Integer[] array = new Integer[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        String[] nextStringArray() {
            return nextLine().split(" ");
        }

        String[] nextStringArray(int n) {
            String[] array = new String[n];
            for (int i = 0; i < n; i++) {
                array[i] = next();
            }
            return array;
        }
    }
}
