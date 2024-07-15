import java.util.*;

public class ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 1;
        HashSet<String> map = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                

                for (int j = 0; j < 26; j++) {
                    char[] w = curr.toCharArray();
                    for (char j2 = 'a'; j2 <= 'z'; j2++) {
                        w[j] = j2;

                        if (map.contains(w.toString())) {
                            if(w.equals(endWord) )return step+1;
                            q.add(w.toString());
                            map.remove(w.toString());
                        }
                    }
                }

            }
            step++;

        }

        return 0;

    }
}
