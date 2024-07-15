package T02_String;
public class SubstringFunction {

    public static String subString(String str, int si, int ei) {
        String subStr = "";
        for (int i = si; i < ei; i++) {
            subStr += str.charAt(i); // bad practice
        }

        return subStr;
    }

    public static void main(String[] args) {
        String str = "chintu";

        System.out.println(subString(str, 2, 4));

        // inbuilt function
        System.out.println(str.substring(2));  // si to str.length();

        System.out.println(str.substring(2, 4));
    }
}
