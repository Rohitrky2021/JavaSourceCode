import java.util.*;

public class Main {

	public static int solution(String str){
		// write your code here
		int len = str.length();
		HashSet<Character> set = new HashSet<>();
		for(int i = 0; i < str.length(); i++){
		    char ch = str.charAt(i);
		    set.add(ch);
		}
		
		int i = -1;
		int j = -1;
		
		HashMap<Character, Integer> map = new HashMap<>();
		while(true){
		    boolean f1 = false;
		    boolean f2 = false;
		    //Acquire Till it Valid 
		    while(i < str.length() - 1 &&  map.size() < set.size()){
		        i++;
		        char ch = str.charAt(i);
		        map.put(ch, map.getOrDefault(ch, 0) + 1);
		        f1 = true;
		    }
		    
		    while(j < i && map.size() == set.size()){
		        int p = i - j; // My Potential ans length 
		        if(p < len){
		            len = p;  // Update the min length 
		        }
		         
		        j++;  // releasing char  --> 2 possibilty to update or remove 
		        char ch = str.charAt(j);
		        if(map.get(ch) == 1){  
		            map.remove(ch);
		        } else {
		            map.put(ch, map.get(ch) - 1);
		        }
		        
		        f2 = true;
		    }
		    
		    if(f1 == false && f2 == false){  //f1--> for loop 1 and f2 for -> if this condn true then DOno loop  m nhi gaye bahar aa jao 
		        break;
		    }
		}                  
		
		return len;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}