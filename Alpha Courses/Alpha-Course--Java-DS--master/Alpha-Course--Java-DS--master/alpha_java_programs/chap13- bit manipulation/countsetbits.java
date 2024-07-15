//WAP to count set bits of a number
public class countsetbits {
    public static int countsetbits(int n) {
        int count = 0;
        while(n > 0) {  //check our LSB (least significant bit)
            if((n & 1) != 0) {
                count++;
            }
            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countsetbits(16));
    }
}
