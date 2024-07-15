import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
import java.util.Map.Entry;
import java.io.PrintStream;

// . There is a party and there is one/no guest who doesn’t know any one but all others know guest . Find the guest.

public class starter {

    // public int findValueOfPartition(int[] nums) {
    // int mini=0;
    // Arrays.sort(nums);
    // // nums[1]-nums[0];
    // for (int i = 0; i < nums.length; i++) {
    // mini=Math.min(mini, nums[i]-nums[i-1]);
    // }

    // return mini;
    // }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // know(a,b) --1-- - a will not be guest
        // b can
        // ---0 --a can be
        // b can't be the guest
        
        while (T-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            // Arrays.sort(arr);

            for (int i = 0; i < arr.length; i++) {
                // if(arr[i]>arr[i+1]){
                // return arr[i+1];
                arr[i] = sc.nextInt();
            }
            if(n<=3){
                System.out.println("BRONZE");
            }else if(n>6){
                System.out.println("GOLD");
            }
            else{
                System.out.println("SILVER");
            }
           
            
   
        }
        // FastReader.nextLong(34);

    }

    // }

    // if return 1 - aknow b
    // else dont know

    // array -n person
    // to find the 1 person;

    // System.out.println(sum);

    public static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public  static Map<Integer, Integer> frequencyMap;

    public static Map<Integer, Integer> getFrequency(int[] elements) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int element : elements) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        
        
        return frequencyMap;
    }
    
    // ********************************************my FAST READER
    // *************************/

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
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
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
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

    /******************* PRINT***************************** */
    // int number = 42;
    // String name = "John Doe";
    // boolean flag = true;

    // print("Number: ");
    // print(number);                                              output:---
    // print(", Name: ");                                          Number: 42, Name: John Doe, Flag: true

    // print(name);
    // print(", Flag: ");
    // print(flag);

    static void print(Object obj) {
        ans.append(obj.toString());
    }

    static Scanner scn;
    static StringBuilder ans;

    // ***************************** ----number of substrings having equal number of
    // 0 and 1 ------******************************//

    private static void solveTC(int __) {

        // code start
        FastReader scn = new FastReader();

        int n = scn.nextInt();
        String str = scn.next();

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < n; i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                sb.append(str.charAt(i));
            }
        }

        int count = 0;
        int lo = 0, hi = sb.length() - 1;

        if (sb.length() <= 1) {
            print(0 + "\n");
            return;
        }

        if (sb.charAt(lo) == '1') {
            count = sb.length() / 2;
        } else {
            count = (sb.length() - 1) / 2;
        }

        print(count);

        // code end

        print("\n");
    }

    static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    public static void reverse(int marks[]){
        int l=0,e=marks.length-1,m=0,n=0;
        while(l<=e){
            // swap(marks[l],marks[e]);
            m=marks[l];
            marks[l]=marks[e];
            marks[e]=m;
            l++;
            e--;
            
        }
        
    System.out.println("the array after swap : " + marks[0]+marks[1]);
    
    }

    public static int bin_search(int marks[],int key){
        int l=0,e=(marks.length-1),c;
        
        while(l<=e){//by using the stair case method
            
            // for(int i=0;i<=marks.length;i++){
                c=(l+e)/2;
                if(marks[c]==key){
                    System.out.println("ya this is the key");
                    return c;
                }
                else if(marks[c]>key){
                    e=c-1;
                System.out.println("right one shifted");
               }
            else if(marks[c]<key){
                l=c+1;
                System.out.println("left one shifted");
            }
            else{
              System.out.println("sorry key is not available" );  
            }
            
        }
        return -1;
    }
    

    // ***************************** ---- Manual sort
    // ------******************************//
    static void sort(long[] a) {
        ArrayList<Long> aa = new ArrayList<>();
        for (long i : a) {
            aa.add(i);
        }
        Collections.sort(aa);
        for (int i = 0; i < a.length; i++)
            a[i] = aa.get(i);
    }

    static void sort(int[] a) {
        ArrayList<Integer> aa = new ArrayList<>();
        for (int i : a) {
            aa.add(i);
        }
        Collections.sort(aa);
        for (int i = 0; i < a.length; i++)
            a[i] = aa.get(i);
    }

    // ****************** */
    public static int change(int arr[]) {

        int count = 0;
        int change[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
    String str=new String();
    

    str.split(" ");
    str.charAt(str.length());
    char op=str.charAt(str.length());
    
    
        // for (int i = 0; i < change.length; i++) {
        // System.out.println(arr[i]);
        // // System.out.println(change[i]);
        // }

        // for (int i = 0; i < change.length; i++) {
        // // System.out.println(arr[i]);
        // System.out.println(change[i]);
        // }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != change[i]) {
                count++;
            }
            // if(count==0){
            // count=-2;
            // }
        }
        return count / 2;
    }

    // BINARY EXPONENTIATION
    public static long binpow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a;
            a = a * a;
            b >>= 1;
        }
        return res;
    }

    // --- Fast exponentiation ---//
    static long pow(long x, long y) {
        long res = 1l;
        while (y != 0) {
            if (y % 2 == 1) {
                res = (x * res);
            }
            y /= 2;
            x = (x * x);
        }
        return res;
    }

    // --- permutations and Combinations ---//
    static long fact[];
    static long invfact[];

    static long ncr(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        long x = fact[n];
        long y = fact[k];
        long yy = fact[n - k];
        long ans = (x / y);
        ans = (ans / yy);
        return ans;
    }

    // >>>>>>>>>>> isPrime <<<<<<<<< //

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int sqr = (int) Math.sqrt(n);
        for (int i = 2; i <= sqr; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // >>>>>>>>>>> LCM <<<<<<<<< //

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    // ******* Greatest Common Divisor **********//

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // ************************* FACToORIAL ************************/
    public static double recursiveFactorial(int number) { // 1 – double can hold very large numbers compared with
                                                          // integer.

        if (number == 0 || number == 1) { // base for calculation. If the number received is 0 or 1 we return 1.
                                          // Factorial of 0 or 1 is 1.

            return 1;

        }
        return number * (recursiveFactorial(number - 1)); // 2 – recursive call.

    }

    // ************************* REVERSE DIGIT OF NUMBER ************************/
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            reversed = reversed * 10 + digit;
        }
        return reversed;
    }

    // ************************* SEGMENTTREE FOR PREFIXSUM AND UPDATE + QUERIES
    // ************************/
    static class SegmentTree {
        int[] tree;
        int n;

        public SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[n * 2];

            // build the segment tree bottom-up
            for (int i = n; i < n * 2; i++) {
                tree[i] = arr[i - n];
            }
            for (int i = n - 1; i > 0; i--) {
                tree[i] = tree[i * 2] + tree[i * 2 + 1];
            }
        }

        public int rangeSum(int startIndex, int endIndex) {
            int sum = 0;
            startIndex += n;
            endIndex += n;
            while (startIndex <= endIndex) {
                if (startIndex % 2 == 1) {
                    sum += tree[startIndex];
                    startIndex++;
                }
                if (endIndex % 2 == 0) {
                    sum += tree[endIndex];
                    endIndex--;
                }
                startIndex /= 2;
                endIndex /= 2;
            }
            return sum;
        }

        public void update(int index, int value) {
            index += n;
            tree[index] = value;
            while (index > 0) {
                int parent = index / 2;
                tree[parent] = tree[parent * 2] + tree[parent * 2 + 1];
                index = parent;
            }
        }

    }

    /**
     * List containing prime numbers <br>
     * <b>i<sup>th</sup></b> position contains <b>i<sup>th</sup></b> prime number
     * <br>
     * 0th index is <b>null</b>
     */
    private static ArrayList<Integer> listOfPrimes;

    /**
     * query <b>i<sup>th</sup></b> element to get if its prime of not
     */
    private static boolean[] isPrime;

    /**
     * Performs Sieve of Erathosnesis and initialise isPrime array and listOfPrimes
     * list
     *
     * @param limit the number till which sieve is to be performed
     */
    private static void sieve(int from,int limit) {
        listOfPrimes = new ArrayList<>();
        listOfPrimes.add(null);
        boolean[] array = new boolean[limit + 1];

        Arrays.fill(array, true);
        array[0] = false;
        array[1] = false;

        // for (int i = 2; i <= limit; i++) {
        for (int i = from; i <= limit; i++) {

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

    
    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("The array is empty.");
        }

        int maxVal = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }

        return maxVal;
    }
    // stuff for prime end

}
