public class stringcompare {
    public static void main(String[] args) {
        String s1 = "karan";
        String s2 = "karan";
        String s3 = new String("karan");
        //comapre
        if(s1 == s2)
        {
            System.out.println("strings are equal");
        }
        else {
            System.out.println("strings are not equal");
        }
        if(s1 == s3) {
            System.out.println("strings are equal");
        }
        else {
            System.out.println("strings are not equal");
        }
    }
}
