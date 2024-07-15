package T02_String;
import java.util.Scanner;

public class StringCompression {

    public static StringBuilder strCompres(String str) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            
            sb.append(str.charAt(i));
            int temp = 1;

            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                temp++;
                i++;
            }

            if (temp > 1) {
                sb.append(temp);
            }
        }

        return sb;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String str = sc.next();
        
        System.out.println(strCompres(str));
        
        sc.close();
    }
}