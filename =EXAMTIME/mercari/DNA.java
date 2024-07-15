public class DNA {
    public static void main(String[] args) {
        String result = dnaComplement("ATCG");
        System.out.println("DNA Complement: " + result);
    }

    static String dnaComplement(String s) {
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        
        // Reverse the DNA sequence
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }

        // Complement the DNA bases
        for (int i = 0; i < charArray.length; ++i) {
            switch (charArray[i]) {
                case 'A':
                    charArray[i] = 'T';
                    break;
                case 'T':
                    charArray[i] = 'A';
                    break;
                case 'C':
                    charArray[i] = 'G';
                    break;
                case 'G':
                    charArray[i] = 'C';
                    break;
                default:
                    break;
            }
        }

        return new String(charArray);
    }
}




string dnaComplement(string s) {
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        start++;
        end--;
    }
    for (int i = 0; i < s.length(); ++i) {
        switch (s[i]) {
            case 'A':
                s[i] = 'T';
                break;
            case 'T':
                s[i] = 'A';
                break;
            case 'C':
                s[i] = 'G';
                break;
            case 'G':
                s[i] = 'C';
                break;
            default:
                break;
        }
    }
    return s;
}
// ercari QS 4
//Comp. a DNA Strand edited 10:52 PM
