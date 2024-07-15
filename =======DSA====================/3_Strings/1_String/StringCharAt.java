package T02_String;
public class StringCharAt {
    public static void printCharacter(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1)
                System.out.println(s.charAt(i));
            else
                System.out.print(s.charAt(i) + ", ");
        }

    }

    public static void main(String[] args) {
        String str = "Mukesh Dixena";
        printCharacter(str);
    }
}
