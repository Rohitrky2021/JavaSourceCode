public class RverseBits {
    
}
public class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed <<= 1; // Left shift the result to make space for the next bit
            reversed |= n & 1; // Add the least significant bit of 'n' to the result
            n >>= 1; // Right shift 'n' to process the next bit
        }
        return reversed;
    }
}
