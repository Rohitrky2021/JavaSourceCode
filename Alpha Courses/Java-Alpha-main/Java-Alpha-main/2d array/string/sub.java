package string;

public class sub {
    public static void main(String[] args) {
        String str = "HelloWorld";
        int str_in =3;
        int str_end =6;

        String sub_string = substring(str,str_in,str_end);
        System.out.print(sub_string);
    }

    private static String substring(String str, int str_in, int str_end) {
        String subb="";
        for(int i = str_in;i<str_end;i++){
            subb += str.charAt(i);
        }
        return subb;
    }
    
}
