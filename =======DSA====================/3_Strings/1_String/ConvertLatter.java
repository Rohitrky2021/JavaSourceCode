package T02_String;
import java.util.Scanner;

public class ConvertLatter {

    public static StringBuilder strUpper(String str) {

        StringBuilder strb = new StringBuilder();

        strb.append(Character.toUpperCase(str.charAt(0)));

        for (int i = 0; i < str.length(); i++) {

            strb.append(str.charAt(i));
            if (str.charAt(i) == ' ' && i < str.length() - 1  && str.charAt(i+1) != ' ') {
                i++;
                strb.append(Character.toUpperCase(str.charAt(i)));
            }
        }

        return strb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(strUpper(str));
        sc.close();
    }
}
