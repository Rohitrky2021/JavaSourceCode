 
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        return new int[] {};
    }
}

public class p5 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] deck1 = {17, 13, 11, 2, 3, 5, 7};
        int[] result1 = solution.deckRevealedIncreasing(deck1);
        System.out.print("Input: deck = [17,13,11,2,3,5,7]\nOutput: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int[] deck2 = {1, 1000};
        int[] result2 = solution.deckRevealedIncreasing(deck2);
        System.out.print("Input: deck = [1,1000]\nOutput: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
