//to find the area of a circle using scanner
import java.util.Scanner;

public class areaofcircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float rad = sc.nextFloat();
        float area = 3.14f * rad * rad;
        System.out.println(area);
        sc.close();
    }
}

/*
 * Explanation-
 * 1. in this, we have written 3.14f as whatever decimal value we put in the code & dont declare that
 * it is float or double then java automatically takes every decimal value as double. so, whenever we want to declare decimal value 
 * as float we have to write f in the end of the number
 */