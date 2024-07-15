public class Jpp1 {
    public static int changeAds(int base10) {
        // Find the position of the highest order 1 bit
        int position = 0;
        int temp = base10;
        while (temp > 0) {
            position++;
            temp >>= 1;
        }
        
        // Create a bitmask to flip the bits from the highest order 1 bit onwards
        int bitmask = (1 << position) - 1;
        
        // Negate the bits by XORing with the bitmask
        int result = base10 ^ bitmask;
        
        return result;
    }
    
    public static void main(String[] args) {
        int base10 = 50;
        int result = changeAds(base10);
        System.out.println(result); // Output: 13
    
        base10 = 100;
        result = changeAds(base10);
        System.out.println(result); // Output: 27
    }
    
    
}
