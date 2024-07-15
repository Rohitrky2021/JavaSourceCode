/*
 Author : Anand Mishra
 Moto :   optimised way 
 */ 

 import java.util.*;
 import java.lang.*;
 import java.io.*;
 import java.math.*;

class Codechef {
    
    // static Function<Pair<Integer, Integer>, Integer> GET_FIRST = (x) -> (x.first);
    // static Function<Pair<Integer, Integer>, Integer> GET_SECOND = (x) -> (x.second);
    // static Comparator<Pair<Integer, Integer>> C2 = Comparator.comparing(x -> x.second);
    // static Comparator<Pair<Integer, Integer>> C1 = Comparator.comparing(x -> x.first);
    // static Comparator<Pair<Integer, Integer>> D1 = Comparator.comparing(x -> x.first);
    // static Comparator<Pair<Integer, Integer>> D2 = Comparator.comparing(x -> x.second);
    static long MOD = 1_000_000_000 + 7;
    static String alpha = "abcdefghijklmnopqrstuvwxyz";

    /* 0.------------------- check prime ------------------- */

    public static boolean isPrime(int n){
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;  
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;  
        return true;
    }

    /* 1. --------------- GCD --------------------- */

    public static int gcd(int a, int b){
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    /* 2. ------------------- Sieve of Eratosthenes -------------------- */

    public static void sieveOfEratosthenes(int n){
        boolean[] prime = new boolean[n+1];
        for(int i=0;i<=n;i++)
            prime[i] = true;
        for(int p = 2; p*p <=n; p++) {
            if(prime[p]) {
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        for(int i = 2; i <= n; i++) {
            if(prime[i]) System.out.print(i + " ");
        }
    }

    /* 3. -------------------- Binary Search -------------------- */

public static  int binarySearch(int[] array, int x, int low, int high) {
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (array[mid] == x) return mid;
        if (array[mid] < x) low = mid + 1;
        else high = mid - 1;
    }
    return -1;
 }

    /* 4.------------------ Check Palindrome -------------------- */

public static boolean isPalindrome(String s){
   int n = s.length();
   for(int i = 0; i < n / 2; i++){
     if(s.charAt(i) != s.charAt(n-i-1)) return false;
   }
   return true;
 }

 /* 5.----------------- fibonacci series --------------------- */

 public static int fib(int n){
  if(n == 0) return 0;
  if(n==1 || n==2) return 1;
  return fib(n-2) + fib(n-1);
}

/* 6. ------------- power of two or not ------------- */

public static boolean isPowerOfTwo(int x) {
  return x!=0 && ((x&(x-1)) == 0);
}

/* 7. ---------- binary Search in string ------------ */

public static int binarySearch(String[] arr, String x){
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2; 
            int res = x.compareTo(arr[m]);
            if (res == 0)
                return m;
            if (res > 0)
                l = m + 1;
            else
                r = m - 1;
        } 
        return -1;
    }

    /* 8. ----------------- LCM of two number ---------------------- */

    public static int LCM(int n, int m){
        int lcm = (n > m) ? n : m;
        while(true) {
            if( lcm % n == 0 && lcm % m == 0 ) {
                return lcm;
            }
            ++lcm;
        }
    }

    /* 9. ----------------- check one string is subsequence of other or not ------------------- */
    
    public static boolean issubsequence(String s1, String s2){
        int n1 = s1.length(), m = s2.length();
        int i = 0, j = 0;
        while (i < n1 && j < m) {
            if (s1.charAt(i) == s2.charAt(j)) i++;
            j++;
        }
        return i == n1;
    }

    //-------------------------------------------max--------------------------------------------------//
   
     public static int max (int a, int b, int c){
        return Math.max(a,Math.max(b,c));
    }
     public static long max (long a, long b, long c){
        return Math.max(a,Math.max(b,c));
    }

    //------------------------------------------min---------------------------------------------------//

     public static int min (int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }
     public static long min (long a, long b, long c){
        return Math.min(a,Math.min(b,c));
    }

    // ---------------------------- KMP algo --------------------------//

    public static int kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] fail = computeFail(pattern);
        int i = 0;
        int j = 0;
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                if (j == m - 1) {
                    return i - m + 1;
                }
                i++;
                j++;
            } else if (j > 0) {
                j = fail[j - 1];
            } else {
                i++;
            }
        }
        return -1;
    }
    
    public static int[] computeFail(String pattern) {
        int m = pattern.length();
        int[] fail = new int[m];
        int i = 1;
        int j = 0;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                fail[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = fail[j - 1];
            } else {
                fail[i] = 0;
                i++;
            }
        }
        return fail;
    }

    //-------------------------------------------topological sort--------------------------------------//
    public static int[] topo(List<List<Integer>> a , int n , int[] in){
        int[] ans = new int[n+1];
        PriorityQueue<Integer> p = new PriorityQueue<>((x,y)->a.get(x).size()-a.get(y).size());
        for(int i =1;i<=n;i++) if(in[i]==0) p.add(i);
        int i =1;
        while(p.size()>0){
            int e = p.poll();
            ans[i++]= e;
            for(int temp : a.get(e)){
                in[temp]--;
                if(in[temp]==0)
                p.add(temp);
            }
        }
        return ans;
    }

    // ---------- sort a list by their freq (if freq are same then sort by their value) --------------//

    public static List<Integer> sortByFrequency(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Collections.sort(list, (a, b) -> {
            int freqCompare = map.get(a).compareTo(map.get(b));
            if (freqCompare == 0) {
                return a.compareTo(b);
            } else {
                return freqCompare;
            }
        });
        return list;
    }
    //-------------------------------------------segment tree-----------------------------------------//
    int[] segment;
    void constructSt(int n, int[] arr){
       segment = new int[n*4+1];
       formSt(arr, 1,0,n-1);
   }
   public void formSt(int[] arr, int node, int s, int e){
       if(s==e){
           segment[node]= arr[s];
           return;
       }
       formSt(arr, node*2,s,s+(e-s)/2);
       formSt(arr, node*2+1,s+(e-s)/2+1,e);
       segment[node]=Math.max(segment[node*2],segment[node*2+1]);
   }
   public  int findMax( int node, int s, int e,int l , int r){
       if(l>e||s>r) return -1;
       if(s==e) return segment[node];
       if(l<=s&&r>=e) return segment[node];
       int mid = s+(e-s)/2;
       return Math.max(findMax(node*2,s,mid,l,r),findMax(node*2+1,mid+1,e,l,r));
   }
   //----------------------------------------binary_exponentiation------------------------------------//
   public long exp(long a, long b, long mod){
       long ans = 1L;
       while(b>0){
           if((b&1)>0) ans = (ans*a)%mod;
           a= (a*a)%mod;
           b>>=1;
       }
       return ans;
   }
   //-----------------------------------------dsu-----------------------------------------//
   int[] parent,rank;
   public void dsu(int n){
       parent = new int[n]; rank = new int[n];
       for(int i =0;i<n;i++) parent[i]=i;
   }
   public  int find(int i){
       if(i==parent[i] ) return i;
       return parent[i]=find(parent[i]);
   }
   public void merge(int i, int j){
       if(rank[i]>=rank[j]){
           rank[i]+=rank[j];
           parent[j]=i;
       }
       else {
           rank[j]+=rank[i];
           parent[i]=j;
       }
   }

   // Comparator sort in java  ---> //
    
   public static class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
public static class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}

// ------------------------------------- //

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
		private final BufferedWriter bw;

		public FastWriter() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(Object object) throws IOException {
			bw.append("" + object);
		}

		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}
	static boolean isPerfectSquare(long number) {
        double sqrt = Math.sqrt(number);
        return ((sqrt - Math.floor(sqrt)) == 0);
    }
    public static void main(String args[])throws IOException
    {        
        // main code -->        
        // FastReader sc=new FastReader();
        // FastWriter out = new FastWriter();
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){

            // cp with Anand --> 

            String s=sc.nextLine;
       
            int count = 0;

            for (int i = s.length() / 2; i < s.length(); i++) {
                char currentChar = s.charAt(i);

                if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                    count++;
                }
            }


        for (int i =0 ; i < s.length() / 2; i++) {
                char currentChar = s.charAt(i);

                if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                    count--;
                }
            }

        return count==0;
        }
	   // out.close();
    }
    
}