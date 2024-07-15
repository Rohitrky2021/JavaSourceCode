
import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BinaryOperator;

public class procfprecode{
    public static final int mod = 1_000_000_007;
    public static final String space = "\\s+";
    public static final Reader in = new Reader();
    public static final String nl = "\n";

    public static void main(String[] args) throws IOException {
        int tt = in.getInt();
        StringBuilder res = new StringBuilder();
        while (tt-->0){
            int n = in.getInt();
            int[] arr = in.getIntArray();
            StringBuilder partRes = new StringBuilder();
            partRes.append(1);
            int prev = arr[0];
            boolean dipped = false;
            for (int i = 1; i < n; i++){
                if (dipped){
                    if (arr[i] >= prev && arr[i] <= arr[0]) {
                        partRes.append(1);
                        prev = arr[i];
                    } else{
                        partRes.append(0);
                    }
                } else{
                    if (arr[i] >= prev) {
                        partRes.append(1);
                        prev = arr[i];
                    } else if (arr[i] <= arr[0]){
                        dipped = true;
                        partRes.append(1);
                        prev = arr[i];
                    } else{
                        partRes.append(0);
                    }
                }
            }
            res.append(partRes.toString()).append(nl);
        }
        System.out.println(res);
    }

    public static class Reader{
        static BufferedReader toread = new BufferedReader(new InputStreamReader(System.in));
        public int[] getIntArray() throws IOException{return Arrays.stream(toread.readLine().split(space)).mapToInt(Integer::parseInt).toArray();}
        public long[] getLongArray() throws IOException{return Arrays.stream(toread.readLine().split(space)).mapToLong(Long::parseLong).toArray();}
        public String[] getStringArray() throws IOException{return toread.readLine().split(space);}
        public int getInt() throws IOException{return Integer.parseInt(toread.readLine());}
        public long getLong() throws IOException{return Long.parseLong(toread.readLine());}
        public String getString() throws IOException{return toread.readLine();}
        public int[][] getIntMatrix(int rows) throws IOException{
            int[] firstrow = Arrays.stream(toread.readLine().split(space)).mapToInt(Integer::parseInt).toArray();int[][] mat = new int[rows][firstrow.length];mat[0] = firstrow;
            for (int i = 1; i < rows; i++) mat[i] = Arrays.stream(toread.readLine().split(space)).mapToInt(Integer::parseInt).toArray();return mat;
        }
        public String[][] getStringMatrix(int rows) throws IOException{
            String[] tokens = toread.readLine().split(space);String[][] mat = new String[rows][tokens.length];mat[0] = tokens;
            for (int i = 1; i < rows; i++) mat[i] = toread.readLine().split(space);return mat;
        }
    }
    public static int min(int... nums){int min = Integer.MAX_VALUE; for (int num : nums) min = Math.min(min,num); return min;}
    public static int max(int... nums){int max = Integer.MIN_VALUE; for (int num : nums) max = Math.max(max,num); return max;}
    public static long min(long... nums){long min = Long.MAX_VALUE; for (long num : nums) min = Math.min(min,num); return min;}
    public static long max(long... nums){long max = Long.MIN_VALUE; for (long num : nums) max = Math.max(max,num); return max;}
    public static void print(int[] arr){for (int num : arr) System.out.print(num+" ");System.out.println();}
    public static void print(long[] arr){for (long num: arr) System.out.print(num+" ");System.out.println();}
    public static void print(String[] arr){for (String str:arr) System.out.println(str+" ");System.out.println();}
    public static void print(int[][] mat){for (int i = 0; i < mat.length; i++)print(mat[i]);}
    public static void print(long[][] mat){for (int i = 0; i < mat.length; i++)print(mat[i]);}
    public static void print(String[][] mat){for (int i = 0; i < mat.length; i++)print(mat[i]);}

    public static void shuffleSort(int[] nums){Random rand = ThreadLocalRandom.current();for (int i = nums.length-1; i > 0; i--)swap(nums, rand.nextInt(i), i);Arrays.sort(nums);}
    public static void shuffleSort(long[] nums){Random rand = ThreadLocalRandom.current();for (int i = nums.length-1; i > 0; i--)swap(nums, rand.nextInt(i), i);Arrays.sort(nums);}
    public static void swap(int[] nums, int index1, int index2){nums[index1] ^= nums[index2] ^(nums[index2] = nums[index1]);}
    public static void swap(long[] nums, int index1, int index2){nums[index1] ^= nums[index2] ^ (nums[index2] = nums[index1]);}
    public static int gcd(int a, int b){if (b == 0) return a;return gcd(b, a%b);}
    public static long gcd(long a, long b){if (b==0) return a; return gcd(b, a%b);}
    public static long pow(int b, int e){long res = 1;while (e > 0){res = (res*b)%mod; e--;} return res;}
    public static List<Integer> getIntList(int[] arr){List<Integer>list=new ArrayList<>();for (int num:arr)list.add(num);return list;}
    public static List<Long> getLongList(long[] arr){List<Long>list=new ArrayList<>();for(long num:arr)list.add(num);return list;}
    public static List<Boolean> getBoolList(boolean[] arr){List<Boolean>list=new ArrayList<>();for(boolean bool:arr)list.add(bool);return list;}
    public static final BinaryOperator<Integer> addints = (a, b)->a+b;
    public static final BinaryOperator<Long> addlongs = (a,b)->a+b;
    public static final BinaryOperator<Boolean> ands = (a,b)->a&&b;
    public static final BinaryOperator<Boolean> ors = (a,b)->a||b;

    public static class UnionFind{
        int[] parent; int[] rank;
        public UnionFind(int n){
            parent = new int[n]; rank = new int[n];
            for (int i = 0; i < n; i++){parent[i] = i;rank[i] = 1;}
        }
        public int find(int p){
            while (p != parent[p]){parent[p] = parent[parent[p]];p = parent[p];}
            return p;
        }
        public void union(int p, int q){
            int rootQ = find(q); int rootP = find(p);
            if (rootQ == rootP) return;
            if (rank[rootP] > rank[rootQ]){parent[rootQ] = rootP;rank[rootP] += rank[rootQ];}
            else{parent[rootP] = rootQ;rank[rootQ] += rank[rootP];}
        }
    }
    public static class ST<T>{
        List<T> tree; BinaryOperator<T> f; int n;
        public ST(List<T> arr, BinaryOperator<T> f){
            this.n = arr.size(); this.f = f; this.tree = new ArrayList<>(2*n);
            for (int i = 0; i < n; i++)tree.add(null);
            for (int i = 0; i < n; i++)tree.add(arr.get(i));
            for (int i = n-1; i > 0; i--)tree.set(i, f.apply(tree.get(2*i),tree.get(2*i+1)));
        }
        public void update(int index, T val){
            index += n; tree.set(index, val);
            while (index > 1){
                index >>= 1;
                tree.set(index, f.apply(tree.get(2*index),tree.get(2*index+1)));
            }
        }
        public T find(int start, int end){
            T res=null; start+=n; end+=n;
            while (start < end){
                if ((start&1)==1){
                    res = res==null ? tree.get(start) : f.apply(res, tree.get(start));
                    start++;
                }
                if ((end&1)==1){
                    end--;
                    res = res==null ? tree.get(end) : f.apply(res, tree.get(end));
                }
                start >>= 1;
                end >>= 1;
            }
            return res;
        }
    }
}



