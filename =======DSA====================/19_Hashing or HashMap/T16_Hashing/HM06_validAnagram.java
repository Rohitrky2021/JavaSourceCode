package T16_Hashing;

import java.util.HashMap;

public class HM06_validAnagram {
    public static void main(String[] args) {
        String s = "race";
        String r = "care";
        System.out.println(isAnagram(s, r));
    }

    public static boolean isAnagram(String s, String r) {

        if (s.length() != r.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < r.length(); i++) {

            char ch = r.charAt(i);

            if (map.containsKey(ch)) {

                if (map.get(ch) > 1) {
                    map.put(ch, map.get(ch) - 1);
                } else {
                    map.remove(ch);
                }

            } else {
                return false;
            }
        }

        return map.isEmpty();

    }
}
