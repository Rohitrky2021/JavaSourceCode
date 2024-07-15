//WAP on string function- substring
public class substring {
    public static String substringfind(String str, int si, int ei) {
        String substr = "";
        for(int i=0; i<ei; i++)
        {
            substr += str.charAt(i);
        }
        return substr;
    }
    public static void main(String[] args) {
        String str = "helloworld";
        System.out.println(substringfind(str, 0, 5));
    }
}
