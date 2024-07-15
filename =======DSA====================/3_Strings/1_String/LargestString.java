package T02_String;
public class LargestString {

    public static String largeString(String str[]){

        String ans = str[0];
        for (int i = 1; i < str.length; i++) {

            /*
                str1.compareTo(str2) == 0 : equal
                str1.compareTo(str2) > 0 (+ve) : str1 > str2
                str1.compareTo(str2) < 0 (-ve) : str1 < str2

                compareTo is caseSensitive compareToIgnoreCase is not

                in compare to 
                    a > A
        
            */
            
            if(ans.compareToIgnoreCase(str[i]) < 0){
                ans = str[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String arr[] = {"banana", "apple", "orange", "mango"};

        String largestr = largeString(arr);
        System.out.println(largestr);

        // if("a".compareTo("A") > 0){
        //     System.out.println("+");
        // }else{
        //     System.out.println("-");
        // }
    }
}
