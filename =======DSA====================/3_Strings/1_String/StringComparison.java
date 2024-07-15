package T02_String;
public class StringComparison {
    public static void main(String[] args) {
        String s1 = "Mukesh";
        String s2 = "Mukesh";
        String s3 = new String("Mukesh");

        if(s1 == s2){ // true
            System.out.println("s1 == s2");
        }else{
            System.out.println("s1 != s2");
        }

        if(s1 == s3){ // false
            System.out.println("s1 == s3");
        }else{
            System.out.println("s1 != s3");
        }

        if(s1.equals(s3)){//true
            System.out.println("s1.equals(s3)");
        }else{
            System.out.println("s1 != s3 (by method) ");
        }

        if(s1.equals(s2)){//true
            System.out.println("s1.equals(s2)");
        }else{
            System.out.println("s1 != s2 (by method)");
        }
        
    }
}
