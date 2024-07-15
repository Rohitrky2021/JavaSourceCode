import java.util.*;

public class Main {

	public static String solution(String s1, String s2) {
		// Initialize an empty string to store the result
		String a = "";
		
		// Create a HashMap to store the frequency of characters in string s2
		HashMap<Character, Integer> map2 = new HashMap<>();
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			// Update the frequency of character ch in the map
			map2.put(ch, map2.getOrDefault(ch, 0) + 1);
		}

	
		
		// Initialize variables for the main algorithm
		int mct = 0; // Current match count
		int dmct = s2.length(); // Desired match count
		HashMap<Character, Integer> map1 = new HashMap<>(); // Map for string s1
		int i = -1; // Right pointer
		int j = -1; // Left pointer
		
		// Main algorithm to find the minimum window substring
		while (true) {
			boolean f1 = false; // Flag to check if there's progress from the right pointer
			boolean f2 = false; // Flag to check if there's progress from the left pointer
			
			// Move the right pointer until we have a match or reach the end of s1
			while (i < s1.length() - 1 && mct < dmct) {
				i++;
				char ch = s1.charAt(i);
				// Update frequency of character ch in map1
				map1.put(ch, map1.getOrDefault(ch, 0) + 1);
				
				// If the current character contributes to the match, increment match count
				if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
					mct++;
				}
				f1 = true; // Progress from the right pointer
			}
			
			// Collect answer and release characters from the left pointer
			while (j < i && mct == dmct) {
				String p = s1.substring(j + 1, i + 1); // Potential minimum window substring
				// Update the result if it's empty or p is shorter than the current result
				if (a.length() == 0 || p.length() < a.length()) {
					a = p;
				}
				
				j++; // Move the left pointer
				char ch = s1.charAt(j);
				// Update frequency of character ch in map1
				if (map1.get(ch) == 1) {
					map1.remove(ch);
				} else {
					map1.put(ch, map1.get(ch) - 1);
				}
				
				// If the current character no longer contributes to the match, decrement match count
				if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
					mct--;
				}
				f2 = true; // Progress from the left pointer
			}
			
			// If there's no progress from both pointers, exit the loop
			if (!f1 && !f2) {
				break;
			}
		}
		
		return a; // Return the minimum window substring
	}

	public static void main(String[] args) {
		// Read input strings from the standard input
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		// Call the solution function and print the result
		System.out.println(solution(s1, s2));
	}
}
