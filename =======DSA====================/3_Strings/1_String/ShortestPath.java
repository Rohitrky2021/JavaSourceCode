package T02_String;
import java.util.Scanner;

public class ShortestPath {

    public static float shortestPath(String s){
        int x = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                x++;
            }
            if(s.charAt(i) == 'w' || s.charAt(i) == 'W'){
                x--;
            }
            if(s.charAt(i) == 'n' || s.charAt(i) == 'N'){
                y++;
            }
            if(s.charAt(i) == 's' || s.charAt(i) == 'S'){
                y--;
            }
        }
        return (float) Math.sqrt(x*x + y*y);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(shortestPath(str));


        sc.close();
    }
}
