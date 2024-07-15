import java.io.*;

import java.sql.PseudoColumnUsage;
import java.util.*;


public class bestpre{


    static class QuickReader {
        BufferedReader in;
        StringTokenizer token;

        public QuickReader(InputStream ins) {
            in = new BufferedReader(new InputStreamReader(ins));
            token = new StringTokenizer("");
        }

        public boolean hasNext() {
            while (!token.hasMoreTokens()) {
                try {
                    String s = in.readLine();
                    if (s == null) return false;
                    token = new StringTokenizer(s);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
            }
            return true;
        }

        public String next() {
            hasNext();
            return token.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] nextInts(int n) {
            int[] res = new int[n];
            for (int i = 0; i < n; i++)
                res[i] = nextInt();
            return res;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public long[] nextLongs(int n) {
            long[] res = new long[n];
            for (int i = 0; i < n; i++)
                res[i] = nextLong();
            return res;
        }

    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored) {
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    private QuickReader sc;
    private PrintWriter ptk;

    public Main(QuickReader sc, PrintWriter ptk) {
        this.sc = sc;
        this.ptk = ptk;
    }

    public static void main(String[] args) {
        QuickReader in = new QuickReader(System.in);

        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));) {
            new qu(in, out).solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sortString(String inputString) {
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        return new String(tempArray);
    }

    static boolean isPalindrome(String str,
                                int low, int high) {
        while (low < high) {
            if (str.charAt(low) != str.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    static int countDigit(long n) {
        return (int) Math.floor(Math.log10(n) + 1);
    }

    static int Digits(long n) {
        int largest = 0;
        int smallest = 9;

        while (n != 0) {
            long r = (n % 10);

            // Find the largest digit
            largest = (int) Math.max(r, largest);

            // Find the smallest digit
            smallest = (int) Math.min(r, smallest);

            n = n / 10;
        }
        return largest;
    }

    static long printDivisors(long n) {
        long count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    count++;
                } else {
                    count++;
                    //count++;
                }

            }
        }
        return count;
    }

    public static ArrayList<Long> primeFactors(long n) {
        // Print the number of 2s that divide n
        ArrayList<Long> arr = new ArrayList<>();
        while (n % 2 == 0) {

            arr.add(2L);
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                arr.add((long) i);
                n /= i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
            arr.add(n);
        return arr;
    }


    public void reverseArray(int[] arr) {
        int len = arr.length;
        int left = 0, right = len - 1 - left;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }


    public void reverseArray(long[] arr) {
        int len = arr.length;
        int left = 0, right = len - 1 - left;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    static boolean isPrime(long n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; (long) i * i <= (n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    void swap(long[] A, int i, int j) {
        long tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    static void swap(int i, int j) {
        int t = i;
        i = j;
        j = t;
    }

    static long factorial(int n) {
        if (n == 0)
            return 1;

        return n * factorial(n - 1) % 1000000007;
    }

    public static boolean cmp(long[] a, long[] b) {
        if (a[0] + a[1] == b[0] + b[1]) {
            return a[0] < b[0];
        } else {
            return a[0] + a[1] < b[0] + b[1];
        }
    }

    boolean checkprime(int n) {
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    static boolean checkPalindrome(String str) {
        int len = str.length();


        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) !=
                    str.charAt(len - i - 1))
                return false;
        }

        return true;
    }

    static int divSum(int num) {
        int result = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == (num / i))
                    result += i;
                else
                    result += (i + num / i);
            }
        }
        return (result + 1 + num);
    }

    public static int lowerBound(long[] arr, long key) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= key) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


    static long findSum(long number) {

        long sum = 0;

        while (number != 0) {

            sum = sum + number % 10;

            number = number / 10;
        }

        return sum;
    }

    public static boolean cmp(ArrayList<Long> a, ArrayList<Long> b) {
        if (a.get(0) + a.get(1) == b.get(0) + b.get(1)) {
            return a.get(0) < b.get(0);
        } else {
            return a.get(0) + a.get(1) < b.get(0) + b.get(1);
        }
    }



    public static int countDistinct(long num) {
        Set<Long> set = new HashSet<>();
        while (num > 0) {
            set.add(num % 10);
            num /= 10;
        }
        return set.size();
    }

    public String xor(String a, String b) {
        String ans = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                ans += '0';
            } else {
                ans += '1';
            }
        }
        return ans;
    }

    static void dfs(ArrayList<ArrayList<Integer>>[] adj, int node, ArrayList<Integer> vis, ArrayList<Integer> dis) {
        vis.set(node, 1);


        for (ArrayList<Integer> x : adj[node]) {
            if (vis.get(x.get(0)) == 0) {
                dis.set(x.get(0), dis.get(node) ^ x.get(1));
                dfs(adj, x.get(0), vis, dis);
            }
        }
    }
    static void search(String pat, String txt, int[] suffArr, int n)
    {

        // Get the length of the pattern
        int m = pat.length();

        // Initialize left and right indexes
        int l = 0;
        int r = n - 1;

        // Do simple binary search for the pat in txt using the built suffix array
        while (l <= r) {

            // Find the middle index of the current subarray
            int mid = l + (r - l) / 2;

            // Get the substring of txt starting from suffArr[mid] and of length m
            String res = txt.substring(suffArr[mid], suffArr[mid] + m);

            // If the substring is equal to the pattern
            if (res.equals(pat)) {

                // Print the index and return
                System.out.println("Pattern found at index " + suffArr[mid]);
                return;
            }

            // If the substring is less than the pattern
            if (res.compareTo(pat) < 0) {

                // Move to the right half of the subarray
                l = mid + 1;
            } else {

                // Move to the left half of the subarray
                r = mid - 1;
            }
        }

        // If the pattern is not found
        System.out.println("Pattern not found");
    }

    static int[] buildSuffixArray(String txt, int n)
    {

        // Create a list of all suffixes
        String[] suffixes = new String[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = txt.substring(i, n);
        }

        // Sort the suffixes
        java.util.Arrays.sort(suffixes);

        // Create the suffix array
        int[] suffArr = new int[n];
        for (int i = 0; i < n; i++) {
            suffArr[i] = txt.indexOf(suffixes[i]);
        }
        return suffArr;
    }
    static int[] isNinjaAlive(int n, int k, int q, int []shield) {
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=k;
        }
        for(int i=0;i<n;i++){
            arr[i]=Math.max(0,arr[i]-q);
        }
        for(int i=0;i<q;i++){
            int jiskepass = shield[i]-1;
            int h = k -i;
            if(h>0){
                arr[jiskepass]++;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                arr[i]=1;
            }
        }
        return arr;

    }
    long lower(long x){
        long y=0;
        while(x>0){
            long u = x%10;
            if(y<u) y=u;
            x = x/10;
        }

        return y;
    }


    long higher(long x){
        long y=9;
        while(x>0){
            long u = x%10;
            if(y>u) y=u;
            x = x/10;
        }

        return y;
    }

    public String valuableString(String arr[], int n){
        String ans=arr[0];
        int max=0;
        for (int i = 0; i <n ; i++) {
            String s=arr[i];
            int v=0;
            int c=0;
            for (int j = 0; j <s.length() ; j++) {
                char c1=s.charAt(j);
                if(c1=='a' || c1=='e' || c1=='i' || c1=='o'||c1=='u'){
                    v++;
                }else{
                    c++;
                }
            }
            if(Math.abs(v-c)>max){
                ans=s;
            }
        }
        return ans;
    }
    static int[] Digits(int n)
    {
        int largest = 0;
        int smallest = 9;

        while(n != 0)
        {
            int r = n % 10;

            // Find the largest digit
            largest = Math.max(r, largest);

            // Find the smallest digit
            smallest = Math.min(r, smallest);

            n = n / 10;
        }
        int [] arr=new int[2];
        arr[0]=smallest;
        arr[1]=largest;
        return arr;

    }
    public static long nearestPowerOf2(long N)
    {
        long a = (int)(Math.log(N) / Math.log(2));

        if (Math.pow(2, a) == N)
            return N;

        return (long) Math.pow(2, a + 1);
    }
int result=0;

    ArrayList<ArrayList<Pair>> g=new ArrayList<>();
    public void solve() throws IOException {
            int tt=sc.nextInt();
            while (tt-->0) {
               String s=sc.next();
               int high = 0;
               int [] arr= new int[s.length()-1];
                int val = (int) s.charAt(s.length()-1)- (int)'A';
                high = (int) Math.max(high,Math.pow(10,val));
                for (int i = s.length()-2; i >=0 ; i--) {
                    arr[i] = high;
                     val = (int) s.charAt(i)- (int)'A';
                    high = (int) Math.max(high,Math.pow(10,val));

                }
                long ans=0;
                for (int i = 0; i <s.length()-1 ; i++) {
                    val = (int) s.charAt(i)- (int)'A';
                    high = (int) Math.pow(10,val);
                    if(high>= arr[i]){
                        ans+= high;
                    }else{
                        ans-=high;
                    }
               //     System.out.println(ans);
                }
                int [] left = new int[5];
                int [] right = new int[5];
                for (int i = 0; i <5 ; i++) {
                    left[i]=Integer.MAX_VALUE;
                }
                for (int i = 0; i <5 ; i++) {
                    right[i]=Integer.MAX_VALUE;
                }
                 val = (int) s.charAt(s.length()-1)- (int)'A';
                high = (int) Math.pow(10,val);
                ans+= high;
               // System.out.println(ans);
                long max=ans;
                long sum=0;
                for (int i = 0; i <s.length() ; i++) {
                    int diff = s.charAt(i)-'A';
                    left[diff] = Math.min(left[diff],i);
                    right[diff] = i;
                }
                String kk="ABCDE";
                for (int i = 0; i <s.length() ; i++) {
                    val = (int) s.charAt(i)- (int)'A';
                    high = (int) Math.pow(10,val);
                    sum+= high;
                    long ss= 0;



                }
                for (int i = 0; i <5 ; i++) {
                    if(right[i]!=Integer.MAX_VALUE){
                        int id = right[i];
                        String k = s;
                        char c= k.charAt(id);
                        for (int j = 0; j <5 ; j++) {
                            char c1 = kk.charAt(j);
                            if(c1!=c){
                                k = k.substring(0,id)+ c1 + k.substring(id+1);
                                max= Math.max(max, sum(k));
                            }
                        }
                    }
                }


                for (int i = 0; i <5 ; i++) {
                    if(left[i]!=Integer.MAX_VALUE){
                        int id = left[i];
                        String k = s;
                        char c= k.charAt(id);
                        for (int j = 0; j <5 ; j++) {
                            char c1 = kk.charAt(j);
                            if(c1!=c){
                                k = k.substring(0,id)+ c1 + k.substring(id+1);
                                max= Math.max(max, sum(k));
                            }
                        }
                    }
                }

             //   System.out.println(sum(s));
                System.out.println(Math.max(sum(s),max));
               // System.out.println(Arrays.toString(arr));
            }

    }
    static void dfs(ArrayList<ArrayList<Integer>>a,int s, boolean[] vis){
        vis[s]=true;
        for (int i : a.get(s)) {
            if(!vis[i]){
                dfs(a,i,vis);
            }
        }
    }
    static long sum(String s){
        int n = s.length();
        int [] arr=new int[n];
 char max_char='A';
for (int i = n-1; i >=0 ; i--) {
    int val = (int) s.charAt(i)- (int)'A';
    int high = (int) Math.pow(10,val);
    if(s.charAt(i)<max_char){
        arr[i]= - high;
    }else{
        max_char= s.charAt(i);
        arr[i] = high;
    }
        }
 long sum=0;
        for (int i = 0; i <n ; i++) {
            sum+=arr[i];
        }
        return sum;
    }
    static long findProductSum(long A[], int n)
    {
        long mod= 1000000007;
        // calculating array sum (a1 + a2 ... + an)
        long array_sum = 0;
        for (int i = 0; i < n; i++)
            array_sum = array_sum + A[i];
            array_sum%=mod;

        // calculating square of array sum
        // (a1 + a2 + ... + an)^2
        long array_sum_square = ((array_sum%mod) * (array_sum%mod));

        // calculating a1^2 + a2^2 + ... + an^2
        int individual_square_sum = 0;
        for (int i = 0; i < n; i++)
            individual_square_sum += ((A[i]%mod) * (A[i]%mod))%mod;

        // required sum is (array_sum_square -
        // individual_square_sum) / 2
        return (array_sum_square - individual_square_sum) / 2;
    }
        boolean isPossible(long m, long[] arr, long k) {
 long count = 0;
            for (long l : arr) {
                if (l < m) {
                    count += m - l;
                } else {
                    break;
                }
            }
 return count <= k;
        }
    void dfs(int s,int par,int v,int c){


        for (int i = 0; i <g.get(s).size() ; i++) {
            int u=g.get(s).get(i).first;

            int p=g.get(s).get(i).second;
            if(u!=par){
                if(p<v){
                    dfs(u,s,p,c+1);
                }else{
                    dfs(u,s,p,c);
                }
            }
        }
        result=Math.max(result,c);
        return;
    }

    void dfs(int r, int p, ArrayList<ArrayList<Integer>> a, ArrayList<Integer>h){
        for(int c : a.get(r)){
            if(c != p){
                h.set(c,h.get(r)+1);

                dfs(c, r,a,h);
            }
        }
    }
    public static long powerof2(long N)
    {
        long a = (int)(Math.log(N) / Math.log(2));

        if (Math.pow(2, a) == N)
            return a;

        return a+1;
    }


    public static class SizeLimitedQueue<E>
            extends LinkedList<E> {

        // Variable which store the
        // SizeLimitOfQueue of the queue
        private int SizeLimitOfQueue;

        // Constructor method for initializing
        // the SizeLimitOfQueue variable
        public SizeLimitedQueue(int SizeLimitOfQueue)
        {

            this.SizeLimitOfQueue = SizeLimitOfQueue;
        }

        // Override the method add() available
        // in LinkedList class so that it allow
        // addition  of element in queue till
        // queue size is less than
        // SizeLimitOfQueue otherwise it remove
        // the front element of queue and add
        // new element
        @Override
        public boolean add(E o)
        {

            // If queue size become greater
            // than SizeLimitOfQueue then
            // front of queue will be removed
            while (this.size() == SizeLimitOfQueue) {

                super.remove();
            }
            super.add(o);
            return true;
        }
    }

    class Pair {
        int first;
        int second;

        // Constructor
        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }

        // Overriding toString method
        //       for beautiful printing of pairs
        @Override
        public String toString() {
            return "(" + first +
                    ", " + second +
                    ')';
        }
        @Override
        public int hashCode() {
            return this.first ^ this.second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            if (first != other.first)
                return false;
            if (second != other.second)
                return false;
            return true;
        }


    }

    static class ArrayOfPairsSorter {

        static void sort(Pair[] arr) {
            Comparator<Pair> comparator = new Comparator<>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return p1.first
                            - p2.first; // To compare the first element
                    // just
                    // change the variable from p1.y
                    // - p2.y to p1.x-p2.x.
                }
            };
            Arrays.sort(arr, comparator);
        }
    }

    boolean checkcorner(long x,long y, long n, long m){
        if(x==1 && y==1 ){
            return true;
        }
        if(x==1 && y==m){
            return true;
        }
        if(x==n && y==1){
            return true;
        }
        if(x==n && y==m){
            return true;
        }
        return false;
    }
    boolean checkedge(long x,long y,long n,long m){
        if((x==1) || (x==n) || (y==1) || (y==m)){
            return true;
        }
        return false;
    }


    public static <K, V extends Comparable<V> > Map<K, V>
    valueSort(final Map<K, V> map)
    {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>() {

            // return comparison results of values of
            // two keys
            public int compare(K k1, K k2)
            {
                int comp = map.get(k1).compareTo(
                        map.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }

        };

        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }

    static int lower_bound(ArrayList<Long> array, long key)
    {
        // Initialize starting index and
        // ending index
        int low = 0, high = array.size();
        int mid;

        // Till high does not crosses low
        while (low < high) {

            // Find the index of the middle element
            mid = low + (high - low) / 2;

            // If key is less than or equal
            // to array[mid], then find in
            // left subarray
            if (key <= array.get(mid)) {
                high = mid;
            }

            // If key is greater than array[mid],
            // then find in right subarray
            else {

                low = mid + 1;
            }
        }

        // If key is greater than last element which is
        // array[n-1] then lower bound
        // does not exists in the array
        if (low < array.size() && array.get(low) < key) {
            low++;
        }

        // Returning the lower_bound index
        return low;
    }
    private static boolean check(long x, long n, long m) {
        long cnt = 0;
        for (long i = 1; i <= n; i++) {
            if (x % i == 0 && x / i <= n) {
                cnt += n - x / i + 1;
            }
        }
        return cnt >= m;
    }
    static long ans = 0;

    static int[] depth = new int[200005];
    static int[][] up = new int[200005][20];



    static int lca(int a, int b) {
        if (depth[b] > depth[a]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        for (int i = 19; i >= 0; i--) {
            if (depth[up[a][i]] >= depth[b]) {
                a = up[a][i];
            }
        }
        if (a == b) {
            return a;
        }
        for (int i = 19; i >= 0; i--) {
            if (up[a][i] != up[b][i]) {
                a = up[a][i];
                b = up[b][i];
            }
        }
        return up[a][0];
    }



    int index(String arr[], String item)
    {
        for (int i = 0; i < arr.length; i++) {
            if (item == arr[i])
                return i;
        }
        return -1;
    }

    public static List<Integer> queryPermutation(int[] permutation) {
        System.out.println(Arrays.toString(permutation));
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();
        String[] indices = response.split(" ");
        List<Integer> result = new ArrayList<>();
        for (String index : indices) {
            result.add(Integer.parseInt(index));
        }
        return result;
    }







    static int highestPowerOf2(long n)
    {
        return (int) (n & (-n));
    }

    static String swap(String str, int i, int j)
    {

        if (j == str.length() - 1)
            return str.substring(0, i) + str.charAt(j)
                    + str.substring(i + 1, j) + str.charAt(i);

        return str.substring(0, i) + str.charAt(j)
                + str.substring(i + 1, j) + str.charAt(i)
                + str.substring(j + 1, str.length());
    }




    public String revstring(String str){
        char ch[]=str.toCharArray();
        String rev="";
        for(int i=ch.length-1;i>=0;i--){
            rev+=ch[i];
        }
        return rev;
    }
    public long show(int l, int r){
        long c;
        int gc = getc(l,r);
        if (gc == 1) {
            c = r - l + 1;
        } else {
            long exp1 = gc - 1;
            long exp2 = gc - 2;
            long term1 = Math.max(r / (1L << exp1) - l + 1, 0L);
            long term2 = Math.max(l - 1L, r / ((1L << exp2) * 3)) - l + 1;
            c = term1 + term2 * (gc - 1);
        }
        return c;
    }
    public int getc(int L, int R)
    {
        return (int)(Math.log(R/L) / Math.log(2))+1;
    }
    public static int compareTo(String str1,
                                String str2)
    {
        for (int i = 0; i < str1.length() &&
                i < str2.length(); i++) {
            if(str1.charAt(i)!=str2.charAt(i)){
                return (int)str1.charAt(i) -
                        (int)str2.charAt(i);
            }
        }


        if (str1.length() < str2.length()) {
            return (str1.length()-str2.length());
        }
        else if (str1.length() > str2.length()) {
            return (str1.length()-str2.length());
        }


        else {
            return 0;
        }
    }


    static long modInverse(long b,long m){
        long g = gcd(b, m) ;
        if (g != 1)
            return -1;
        else
        {
            //If b and m are relatively prime,
            //then modulo inverse is b^(m-2) mode m
            return (long) (Math.pow(b, m - 2) % m);
        }
    }
    static boolean isItcorrect(ArrayList<Long> arr){
        Set<Long> nset=new HashSet<>();
        for (int i = 0; i <arr.size() ; i++) {
            nset.add(arr.get(i));
        }
        if(nset.size()==1){
            return true;
        }
        return false;
    }
    static long modDivide(long a,long b,long m){
        a = a % m;
        long inv = modInverse(b,m);
        if(inv == -1){
            return 0;
        }
        else{
            return (inv*a) % m;
        }
    }
    static int power(int x, int y, int p)
    {
        int res = 1; // Initialize result

        x = x % p; // Update x if it is more than or
        // equal to p

        if (x == 0)
            return 0; // In case x is divisible by p;

        while (y > 0)
        {

            // If y is odd, multiply x with result
            if ((y & 1) != 0)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }

    static ArrayList<Long> diviors(long n)
    {
        ArrayList<Long> a=new ArrayList<>();
        // Note that this loop runs till square root
        for (int i=1; i<=Math.sqrt(n); i++)
        {
            if (n%i==0)
            {
                // If divisors are equal, print only one
                if (n/i == i) {
                    a.add((long) i);
                }
                else { // Otherwise print both
                    a.add((long) i);
                    a.add(n / i);
                }

            }
        }
        return a;
    }






















    static int mex(int[] a) {
        int n=a.length;
        boolean[] have=new boolean[n+1];
        for (int i:a) have[i]=true;
        for (int i=0; i<=n; i++) if (!have[i]) return i;
        throw null;
    }

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
    static void sort(long[] a) {
        ArrayList<Long> l=new ArrayList<>();
        for (long i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> unsortMap) {

        List<Map.Entry<K, V>> list =
                new LinkedList<>(unsortMap.entrySet());

        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;

    }


    static class MultiSet<E> {
        // TreeSet Version
        TreeMap<E, Integer> Counter = new TreeMap<>();
        private int size = 0;
        public void add(E key) { Counter.put(key, Counter.getOrDefault(key, 0) + 1); size ++; }
        public void remove(E key) {
            int value = Counter.get(key);
            if (value == 1) Counter.remove(key);
            else Counter.put(key, value - 1);
            size --;
        }
        public void deleteAll(E key) { size -= Counter.remove(key); }
        public boolean contains(E item) { return Counter.containsKey(item); }
        public int size() { return size; }
        public boolean isEmpty() { return size == 0; }
        public E ceiling(E item) { return Counter.ceilingKey(item); }
        public E floor(E item) { return Counter.floorKey(item); }
        public E higher(E item) { return Counter.higherKey(item); }
        public E lower(E item) { return Counter.lowerKey(item); }
        public E first() { return Counter.firstKey(); }
        public E last() { return Counter.lastKey(); }
        public String toString() { return Counter.toString(); }
    }
    static long lcm(long a, long b)
    {
        return (a / gcd(a, b)) * b;
    }
    private static long gcd(long a, long b)
    {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}