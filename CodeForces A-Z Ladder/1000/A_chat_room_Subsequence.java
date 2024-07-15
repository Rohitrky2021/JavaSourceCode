import java.util.Scanner;


// Easiest way 
public class A_chat_room_Subsequence {
    public static void main(String[] args) {
        String check = "hello";
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int j = 0; // Initialize a pointer for the 'hello' string

        // Iterate through the typed word 's'
        for (char letter : s.toCharArray()) {
            if (letter == check.charAt(j)) {
                j++; // Move to the next character in 'hello'

                if (j == 5) {
                    System.out.println("YES");
                    return; // Exit the loop since we found 'hello'
                }
            }
        }

        // If we didn't find 'hello', print "NO"
        System.out.println("NO");
    }
}


public class A_chat_room_Subsequence {
    public static void main(String[] args) {
            String check="hello";
            Scanner sc=new Scanner(System.in);
            String s=sc.next();
        int s1=0,c1=0,n=5;
            while(c1<n){
                if(s1==s.length()){
                    System.out.println("NO");
                    break;
                }
                if(s.charAt(s1)==check.charAt(c1)){
                    s1++;c1++;
                    if(c1==n){
                        System.out.println("YES");
                        break;
                        
                    }
                    continue;
                }
                s1++;
             

            }

            // System.out.println("yes");


    }
}
