import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        if (k >= n) {
            // If k is greater than or equal to n, the player with the highest skill will win.
            int maxSkillIndex = 0;
            for (int i = 1; i < n; i++) {
                if (skills[i] > skills[maxSkillIndex]) {
                    maxSkillIndex = i;
                }
            }
            return maxSkillIndex;
        }
        
        // Deque to simulate the queue of players
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.addLast(i);
        }
        
        // Track the number of consecutive wins of the current winner
        int consecutiveWins = 0;
        int currentWinner = queue.pollFirst();
        
        while (consecutiveWins < k) {
            int challenger = queue.pollFirst();
            
            if (skills[currentWinner] > skills[challenger]) {
                // Current winner wins again
                consecutiveWins++;
                queue.addLast(challenger);
            } else {
                // Challenger becomes the new winner
                queue.addLast(currentWinner);
                currentWinner = challenger;
                consecutiveWins = 1;
            }
        }
        
        return currentWinner;
    }
}
