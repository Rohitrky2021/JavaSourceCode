import java.util.*;
// https://leetcode.com/problems/subarrays-with-k-different-integers/solutions/1996719/for-those-who-didn-t-understand-why-exactly-k-atmost-k-atmost-k-1-works/

public class Main {
    public static int solutionfork(String str){
        int ans = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;
            while(i < str.length() - 1){
                f1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                
                if(map.size() == 2){
                    removeInMap(map, ch);
                    i--;
                    break;
                }
            }
            
            while(j < i){
                f2 = true;
                
                if(map.size() == 1){
                    ans = ans + i - j;
                }
                
                j++;
                char ch = str.charAt(j);
                removeInMap(map, ch);
                
                if(map.size() == 0){
                    break;
                }
            }
            if(f1 == false && f2 == false){
                break;
            }
        }
        return ans;
    }

	public static int solution(String str, int k){
		// write your code here
		int ans = 0;
		
		if(k == 1){
		    return solutionfork(str);
		}
		HashMap<Character, Integer> mapb = new HashMap<>();
		HashMap<Character, Integer> maps = new HashMap<>();
		int ls = -1;
		int lb = -1;
		int j = -1;
		
		while(true){
		    boolean f1 = false;
		    boolean f2 = false;
		    boolean f3 = false;
		    
		    while(lb < str.length() - 1){
		        f1 = true;
		        
		        lb++;
		        char ch = str.charAt(lb);
		        mapb.put(ch, mapb.getOrDefault(ch, 0) + 1);
		        
		        if(mapb.size() == k + 1){
		            removeInMap(mapb, ch);
		            lb--;
		            break;
		        }
		    }
		    while(ls < lb){
		        f2 = true;
		        ls++;
		        char ch = str.charAt(ls);
		        maps.put(ch, maps.getOrDefault(ch, 0) + 1);
		        
		        if(maps.size() == k){
		            removeInMap(maps, ch);
		            ls--;
		            break;
		        }
		    }
		    
		    while(j < ls){
		        f3 = true;
		        
		        if(mapb.size() == k && maps.size() == k - 1){
		            ans += lb - ls;
		        }
		        
		        j++;
		        char ch = str.charAt(j);
		        removeInMap(maps, ch);
		        removeInMap(mapb, ch);
		        
		        if(maps.size() < k - 1 || mapb.size() < k){
		            break;
		        }
		    }
		    
		    if(f1 == false && f2 == false && f3 == false){
		        break;
		    }
		}

		return ans;
	}
	
	public static void removeInMap(HashMap<Character, Integer> map, char ch){
	    if(map.get(ch) == 1){
	        map.remove(ch);
	    } else {
	        map.put(ch, map.get(ch) - 1);
	    }
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}


 

public class Main {

    public static int solution(String str, int k) {
        int ans = 0;
        
        if (k == 1) {
            // If k is 1, call the previous solution which counts all possible substrings with unique characters.
            return solutionfork(str);
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < str.length()) {
            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() > k) {
                // If the number of distinct characters exceeds k, move the left pointer.
                char leftChar = str.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            // Count the substrings that meet the criteria.
            ans += right - left + 1;

            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(solution(str, k));
    }

    // The previous solution for k = 1
    public static int solutionfork(String str) {
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
}


public static int solution(String str, int k) {
    int ans = 0;
    int i = 0;
    int j = 0;
    HashMap<Character, Integer> map = new HashMap<>();

    while (i < str.length()) {
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);

        // If k is greater than 1, reduce the window size if needed.
        while (map.size() > k) {
            char removedChar = str.charAt(j);
            map.put(removedChar, map.get(removedChar) - 1);
            if (map.get(removedChar) == 0) {
                map.remove(removedChar);
            }
            j++;
        }

        // Count the substrings that meet the criteria.
        ans += i - j + 1;

        i++;
    }

    return ans;
}
