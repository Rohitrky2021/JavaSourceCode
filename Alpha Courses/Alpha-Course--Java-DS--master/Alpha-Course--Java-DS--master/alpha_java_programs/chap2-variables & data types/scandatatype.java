//program on scanner with data types like int and float
import java.util.Scanner;
public class scandatatype {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(); //int datatype
        System.out.println(number);
        float price = sc.nextFloat(); //float datatype
        System.out.println(price);
        byte word = sc.nextByte(); //byte datatype
        System.out.println(word);
        double decimal = sc.nextDouble(); //double datatype
        System.out.println(decimal);
        long big = sc.nextLong(); //long datatype
        System.out.println(big);
        short small = sc.nextShort(); //short datatype
        System.out.print(small);
        boolean alpha = sc.nextBoolean(); //boolean datatype
        System.out.println(alpha);
        sc.close();
    }
}
