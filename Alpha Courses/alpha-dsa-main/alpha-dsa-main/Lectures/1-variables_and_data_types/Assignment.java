import java.util.*;

public class Assignment {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Cost of pencil: ");
        float c1 = sc.nextFloat();
        System.out.print("Cost of pen: ");
        float c2 = sc.nextFloat();
        // System.out.print("Cost of eraser: ");
        // float $ = sc.nextFloat();
        int $ = 5;
        float total_cost = c1 + c2 + $;
        float gst = 0.18f * total_cost;
        System.out.println(total_cost + gst);
        sc.close();
    }
}
