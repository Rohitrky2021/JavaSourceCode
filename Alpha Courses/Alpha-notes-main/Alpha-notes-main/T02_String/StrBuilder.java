package T02_String;
public class StrBuilder {
    public static void main(String[] args) {
        StringBuilder strb = new StringBuilder("");
        StringBuilder strb2 = new StringBuilder();//both are same

       for(char ch = 'a'; ch <= 'z'; ch++){
            strb.append(ch);
            strb2.append(ch);
       }

       System.out.println(strb);
       System.out.println(strb2);
       System.out.println(strb.length());

    }
}
