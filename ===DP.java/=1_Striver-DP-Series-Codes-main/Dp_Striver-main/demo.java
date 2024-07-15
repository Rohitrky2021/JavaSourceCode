import java.util.*;

public class demo {
    // public static void f(int i, int n) {
    //     if (i > n) {
    //         return;
    //     }
    //     System.out.println(i);
    //     f(i + 1, n);
    // }

    // public static void f2(int i, int n) {
    //     if (i > n)
    //         return;

    //     System.out.println(i + ". Komal");
    //     f2(i + 1, n);
    // }

    // public static void f3(int i, int n) {
    //     if (n < i)
    //         return;

    //     System.out.println(n);
    //     f3(i, n - 1);
    // }

    // public static void main(String[] args) {
    //     // Scanner scn = new Scanner(System.in);
    //     // int n = scn.nextInt();
    //     // scn.close();

    //     // printt countt from 1 to n
    //     // f(1, n);

    //     // print your name n times
    //     // f2(1, n);

    //     // print from n to 1
    //     // f3(1, n);

    //     // print from n to 1 by backtracking
    //     // f4(1, n);

    //     // int[] arr = {1, 2, 5, 6, 3};

    //     // display(arr);

    //     // // reverse arr using two pointer
    //     // // reverse(arr, 0, arr.length - 1);

    //     // // reverse using single pointer
    //     // reverse2(arr, 0);

    //     // display(arr);

    //     // check the string is pallindrome or not

    //     // String str = "madam";
    //     // char[] ch = str.toCharArray();

    //     // System.out.println(pallindrome(ch, 0));

    //     // given array arr = {3, 1, 2} print all its subsequence

    //     int[] arr = { 3, 1, 2 };

    //     ArrayList<Integer> ans = new ArrayList<>();
    //     printSubsequence(arr, 0, ans);

    // }

    // public static void printSubsequence(int[] arr, int si, ArrayList<Integer> ans){
    //     if(si >= arr.length){
    //         if(ans.size() == 0) { System.out.println("[]");
    //         return; }
    //         System.out.println(ans);
    //         return;
    //     }

    //     printSubsequence(arr, si + 1, ans);

    //     ans.add(arr[si]);
    //     printSubsequence(arr, si+1, ans);
    //     ans.remove(ans.size() - 1);
    // }

    // public static boolean pallindrome(char[] ch, int si) {
    //     if (si >= ch.length / 2)
    //         return true;

    //     if (ch[si] != ch[ch.length - 1 - si])
    //         return false;

    //     return pallindrome(ch, si + 1);
    // }

    // public static void reverse2(int[] arr, int si) {
    //     if (si >= arr.length / 2)
    //         return;
    //     swap(arr, si, arr.length - 1 - si);
    //     reverse2(arr, si + 1);
    // }

    // public static void reverse(int[] arr, int si, int ei) {
    //     if (si >= ei) {
    //         return;
    //     }

    //     swap(arr, si, ei);
    //     reverse(arr, si + 1, ei - 1);
    // }

    // public static void swap(int[] arr, int si, int ei) {
    //     int temp = arr[si];
    //     arr[si] = arr[ei];
    //     arr[ei] = temp;
    // }

    // public static void display(int[] arr) {
    //     for (int i = 0; i < arr.length; i++) {
    //         System.out.print(arr[i] + " ");
    //     }

    //     System.out.println();
    // }

    // public static void f4(int i, int n) {
    //     if (i > n)
    //         return;
    //     f4(i + 1, n);
    //     System.out.println(i);
    // }
    public static void main(String[] args) {
        // String s = "abaccb";
        // int[] distance = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        // HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        // for(int i = 0; i < s.length(); i++){
        //     char ch = s.charAt(i);
        //     if(map.containsKey(ch)){
        //         map.get(ch).add(i);
        //     }
        //     else{
        //         ArrayList<Integer> list = new ArrayList<>();
        //         list.add(i);
        //         map.put(ch, list);
        //     }
        // }

        // for(char ch : map.keySet()){
        //     ArrayList<Integer> list = map.get(ch);
        //     int fo = list.get(0);
        //     int sc = list.get(1);
        //     int diff = sc - fo - 1;
        //     System.out.println(diff + " " + distance[ch - 'a']);
        // }

        int[] arr ={1, 3, 8, 48, 10};
        int[] dp = new int[arr.length];

        Arrays.fill(dp, 1);
        int first = arr[0];
        int max = 1;

        for(int i = 1; i < arr.length; i++){
            int second = arr[i];
            int op = first & second;
            System.out.println(op);
            if(op == 0 && arr[i-1] < arr[i]) dp[i] = dp[i-1] + 1;
            max = Math.max(max, dp[i]);
            first = second;
        }

        for(int val : dp) System.out.println(val);
        System.out.println(max);
    }
}