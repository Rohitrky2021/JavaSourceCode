//WAP to convert binary to decimal
public class binarytodecimal {
    public static void bintodec(int binNum) {
        int myNum = binNum;
        int pow = 0; //pow is power
        int decNum = 0;
        while (binNum >0) {
            int lastdigit = binNum % 10; //to find the last digit divide it by 10
            decNum = decNum + (lastdigit * (int)Math.pow(2, pow)); //Math is an inbuilt function
            pow++;
            binNum = binNum/10; //to minimize the binary number
        }
        System.out.println("decimal of " + myNum +" = " +decNum);
    }
    public static void main(String[] args) {
        bintodec(101);
    }
}
