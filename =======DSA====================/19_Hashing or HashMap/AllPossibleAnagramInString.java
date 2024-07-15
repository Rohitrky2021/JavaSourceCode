class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        char pi[] = p.toCharArray();
        char si[] = s.toCharArray();
        int hash[] = new int[26]; // for baap
        int curr[] = new int[26]; // my winodw array

        List<Integer> ans = new LinkedList<>();

        int tail = 0, anss = 0, sum = 0, head/*makeing it global */;

        for (int i = 0; i < pi.length; i++) {
            hash[pi[i] - 'a']++;
        }

        for (head = 0; head < si.length; head++) {
            if (Arrays.equals(hash, curr)) {ans.add(tail);count++;}
 
            while (head - tail + 1 > p.length()) {
                curr[si[tail] - 'a']--;
                tail++;
            }
            curr[si[head] - 'a']++;
        }

        if (Arrays.equals(hash, curr)){ ans.add(tail);count++;}
        // return head-tail+1;
        return ans;
    }
}

 

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] pChars = p.toCharArray();
        char[] sChars = s.toCharArray();
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (char c : pChars) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        List<Integer> result = new LinkedList<>();

        int tail = 0;
        int count = 0;

        for (int head = 0; head < sChars.length; head++) {
            char headChar = sChars[head];
            sMap.put(headChar, sMap.getOrDefault(headChar, 0) + 1);

            if (head - tail + 1 == p.length()) {
                if (sMap.equals(pMap)) {
                    result.add(tail);
                    count++;
                }

                char tailChar = sChars[tail];
                sMap.put(tailChar, sMap.get(tailChar) - 1);
                if (sMap.get(tailChar) == 0) {
                    sMap.remove(tailChar);
                }
                tail++;
            }
        }

        if (sMap.equals(pMap)) {
            result.add(tail);
            count++;
        }

        return result;
    }
}
