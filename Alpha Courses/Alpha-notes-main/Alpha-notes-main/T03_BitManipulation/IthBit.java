package T03_BitManipulation;

import java.util.Scanner;

public class IthBit {

    public static int getbit(int n, int i) {
        // int mask = (1<<i);
        // int temp1 = (n&mask);
        // int temp2 = (temp1>>i);
        // return temp2;

        // if((n&(1<<i)) == 0){
        // return 0;
        // }else{
        // return 1;
        // }

        return (n & (1 << i)) >> i;
    }

    public static int setBit(int n, int i) {
        return (n | (1 << i));
    }

    public static int clearBit(int n, int i) {
        return (n & (~(1 << i)));
    }

    public static int updateBit(int n, int i, int newBit) {
        if (newBit == 0) {
            return clearBit(n, i);
        } else {
            return setBit(n, i);
        }
    }

    public static int clearLastBit(int n, int i) {
        int mask = (~0) << i;

        return n & mask;

    }

    public static int clearRangOfBits(int n, int l, int r) {
        int a = (~0) << l;
        int b = ~((~0) << r);
        int mask = a | b;
        System.out.println(mask);
        return (n & mask);
    }
    public static int countSetBit(int n){
        int count = 0;
        while(n != 0){
            if((n&1) == 1){
                count++;
            }

            n = n >> 1;
        }
        return count;
    }
    // public static int power(int a, int b){
    //     int ans = 1;
    //     while(b )
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int i = sc.nextInt();

        // System.out.println(getbit(n, i));
        // System.out.println(setBit(n, i));
        // System.out.println(clearBit(n, i));
        // System.err.println(clearLastBit(15,2));
        // System.err.println(clearRangOfBits(1023, 6, 4));
        System.out.println(countSetBit(n));

        sc.close();
    }
}
