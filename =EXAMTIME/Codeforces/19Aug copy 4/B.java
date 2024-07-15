import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
         int n = scanner.nextInt();
        int p = scanner.nextInt();
        scanner.nextLine(); 
        String s = scanner.nextLine();
        
       
        char[] chars = s.toCharArray();
         
        boolean possible = false;
        for (int i = 0; i <= n - p - 1; i++) {
            if (chars[i] == '.' || chars[i + p] == '.' || chars[i] != chars[i + p]) {
                
                if (chars[i] == '.' && chars[i + p] == '.') {
                    chars[i] = '0';
                    chars[i + p] = '1';
                } else if (chars[i] == '.') {
                     
                    chars[i] = (chars[i + p] == '0') ? '1' : '0';
                } else if (chars[i + p] == '.') {
                    
                    chars[i + p] = (chars[i] == '0') ? '1' : '0';
                }
                possible = true;
                break;
            }
        }
        
        
        for (int i = 0; i < n; i++) {
            if (chars[i] == '.') {
                chars[i] = '0';
            }
        }
        
       
        if (possible) {
            System.out.println(new String(chars));
        } else {
            System.out.println("No");
        }
        
        scanner.close();
    }
}
