import java.util.Arrays;

public class anag {

	final static int NO_OF_CHARS = 256;

	/* function to check whether two strings are anagram of each other */
	static boolean areAnagram(String str1, String str2) {
		// Create two count arrays and initialize all values as 0
		int[] count = new int[NO_OF_CHARS];
		Arrays.fill(count, 0);

		// For each character in input strings, increment count in
		// the corresponding count array
		for (int i = 0; i < str1.length() && i < str2.length(); i++) {
			count[str1.charAt(i)]++;
			count[str2.charAt(i)]--;
		}

		// If both strings are of different length. Removing this condition
		// will make the program fail for strings like "aaca" and "aca"
		if (str1.length() != str2.length())
			return false;

		// See if there is any non-zero value in count array
		for (int i = 0; i < NO_OF_CHARS; i++)
			if (count[i] != 0)
				return false;
		return true;
	}

	// This function prints all anagram pairs in a given array of strings
	static void findAllAnagrams(String arr[],String newarr[], int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				// If the original strings are anagrams, print them
				if (areAnagram(newarr[i], arr[j]))
					System.out.println(arr[i] + " is anagram of " + arr[j]);
			}
		}
	}

	/* Driver program to test to print printDups */
	public static void main(String[] args) {
        String[] arr = { "geeksquiz", "geeksforgeeks", "abcd", "forgeeksgeeks", "zuiqkeegs" };
		int n = arr.length;
        String[] newArray = new String[n];

        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i] + arr[i];
        }

		findAllAnagrams(arr,newArray, n);
	}
}
