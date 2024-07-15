public class vowel {
    public static void main(String[] args){
        String s="0010001000001000";
        // vowel(s);
        
        // vowel("fojisgsiog13jij");
        // System.out.println(s.repeat(3));
        String st[]= s.split("10");
        System.out.println(st.length);
        // System.out.println(s.arr);
        
        
        // replacem();
        // replacem(s);

    }
    public static void vowel(String s){
        int m=0;
        for (int i = 0; i < s.length(); i++) {
           char c= s.charAt(i);

            if(c =='1' ||c=='e'||c=='i'||c=='o'||c=='u'){
                m++;
                System.out.print(c);

            }
            
        }System.out.println();
        System.out.println( m);
    }
    public static void replacem(String xzy) {
        String str = "Apnaa College".replace("Apnaa", "i");
                System.out.print(str);
                String s1=str.replaceAll("Apnaa", "o");
                // str.split("0101");
                System.out.println(s1);

        }
}
