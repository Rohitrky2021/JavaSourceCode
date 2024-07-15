public class FourthBit {
    public static void main(String[] args) {
        int result = fourthBit(15);
        System.out.println("Value of the 4th bit: " + result);
    }

    static int fourthBit(int number) {
        int[] binary = new int[32];
        int index = 0;

        while (number > 0) {
            binary[index] = number % 2;
            number = number / 2;
            index++;
        }

        return (index >= 4) ? binary[3] : 0;
    }
}





int fourthBit(int number) { int binary[32];
    int index = 0;
    while (number > 0) { binary[index] = number % 2;
        number = number / 2; index++;
    }
    return (index >= 4) ? binary[3] : 0;}
// ercari QS 3
//4th Bit edited 10:52 PM
