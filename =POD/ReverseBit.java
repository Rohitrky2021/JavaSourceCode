import java.util.*;

public class ReverseBit {
    public static void main(String[] args) {
        int n = 23; // Example input integer
        int reversed = reverseBits(n);
        System.out.println("Original: " + Integer.toBinaryString(n));
        System.out.println("Reversed: " + Integer.toBinaryString(reversed));
    }

    public static int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed <<= 1; // Left shift the result to make space for the next bit
            reversed |= n & 1; // Add the least significant bit of 'n' to the result
            n >>= 1; // Right shift 'n' to process the next bit
        }
        return reversed;2
    }
}
