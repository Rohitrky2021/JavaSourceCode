package Recursion.DiceThrowAndLetterOfAPhoneNumberQuestions;

import java.util.ArrayList;

public class NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        int target = 8;
        printCombinations("", target);
        System.out.println(returnCombinations("", target));
        System.out.println(countCombinations("", target));
        System.out.println(nFaceCombinations("", target, 10));
    }

    static ArrayList<String> nFaceCombinations(String p, int target, int face) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            ans.addAll(nFaceCombinations(p + i, target - i, face));
        }
        return ans;
    }

    static int countCombinations(String p, int target) {
        if (target == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= 6 && i <= target; i++) {
            count = count + countCombinations(p + i, target - i);
        }
        return count;
    }

    static ArrayList<String> returnCombinations(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            ans.addAll(returnCombinations(p + i, target - i));
        }
        return ans;
    }

    static void printCombinations(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            printCombinations(p + i, target - i);
        }
    }
}
