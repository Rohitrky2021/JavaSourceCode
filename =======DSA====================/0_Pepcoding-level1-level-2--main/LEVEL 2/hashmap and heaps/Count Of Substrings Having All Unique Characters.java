import java.util.*;

public class Main {

	public static int solution(String str) {
		// write your code here
		int a = 0;
		
		int i = -1;
		
		int j = -1;
		
		HashMap<Character, Integer> map = new HashMap<>();
		while(true){
		    boolean f1 = false;
		    boolean f2 = false;
		    
		    while(i < str.length() - 1){
		        f1 = true;
		        i++;
		        char ch = str.charAt(i);
		        map.put(ch, map.getOrDefault(ch, 0) + 1);
		        
		        if(map.get(ch) == 2){
		            break;
		        } else {
		            a = a + i - j;
		        }
		    }
		    
		    while(j < i){
		        f2 = true;
		        j++;
		        char ch = str.charAt(j);
		        map.put(ch, map.get(ch) - 1);
		        
		        if(map.get(ch) == 1){
		            a = a + i - j;
		            break;
		        }
		    }
		    
		    if(f1 == false && f2 == false){
		        break;
		    }
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
 

public class Main {

    public static int solution(String str) {
        int a = 0;
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (i < str.length()) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // If a character is repeated, slide the window from the left until it is unique.
            while (map.get(ch) > 1) {
                char removedChar = str.charAt(j);
                map.put(removedChar, map.get(removedChar) - 1);
                j++;
            }

            // Add the count of all possible substrings ending at i.
            a += (i - j + 1);

            i++;
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
