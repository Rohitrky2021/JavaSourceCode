class A {
    public String maximumOddBinaryNumber(String s) {
        int countOnes = 0;
        int n = s.length();
        
        // Count the number of '1's in the input string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                countOnes++;
            }
        }
        
        // Create a StringBuilder to build the result
        StringBuilder result = new StringBuilder();
        
        // Append '1's to the result, leaving one '1' for the last position
        for (int i = 0; i < countOnes - 1; i++) {
            result.append('1');
        }
        
        // Append '0's to the result
        for (int i = 0; i < n - countOnes; i++) {
            result.append('0');
        }
        
        // Append the last '1' to the end
        result.append('1');
        
        return result.toString();
    }
}
