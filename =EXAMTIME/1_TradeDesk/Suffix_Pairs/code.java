public class code {

    public static int countSuffixPairs(String[] strings) { // abhi for Sufix startsWith
        int count = 0;

        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].endsWith(strings[j]) || strings[j].endsWith(strings[i])) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] stringArray = { "back", "backdoor", "gammon", "backgammon", "comeback", "come", "door" };
        // String[] stringArray = {"abc","a","a","b","ab","ac"};

        int result = countSuffixPairs(stringArray);
        System.out.println("Number of pairs where one is the suffix of the other: " + result);
    }

    class Solution {
        public int countPrefixSuffixPairs(String[] wd) {
            int n = wd.length;

            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (wd[i].startsWith(wd[j]) && wd[i].endsWith(wd[j])) {

                        count++;
                    }
                }
            }

            return count;
        }
    }

}
