package Recursion.DiceThrowAndLetterOfAPhoneNumberQuestions;

import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String str = "2345";
        phonePad("", str);
        System.out.println(phonePadReturn("", str));
        System.out.println(countCombinations("", str));
    }

    static int countCombinations(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }

        int count = 0;

        int digit = up.charAt(0) - '0';
        int start = 0;
        int end = 0;

        if (digit < 2) {
            return 0;
        }
        if (digit < 7) {
            start = (digit - 2) * 3;
            end = start + 3;
        } else if (digit == 7) {
            start = (digit - 2) * 3;
            end = start + 4;
        } else if (digit == 8) {
            start = 19;
            end = start + 3;
        } else {
            start = 22;
            end = start + 4;
        }

        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            count = count + countCombinations(p + ch, up.substring(1));
        }

        return count;

    }

    static ArrayList<String> phonePadReturn(String p, String up) {

        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        int digit = up.charAt(0) - '0';
        int start = 0;
        int end = 0;

        if (digit < 2) {
            return new ArrayList<>();
        }
        if (digit < 7) {
            start = (digit - 2) * 3;
            end = start + 3;
        } else if (digit == 7) {
            start = (digit - 2) * 3;
            end = start + 4;
        } else if (digit == 8) {
            start = 19;
            end = start + 3;
        } else {
            start = 22;
            end = start + 4;
        }

        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(phonePadReturn(p + ch, up.substring(1)));
        }

        return ans;

    }

    static void phonePad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        int start = 0;
        int end = 0;
        if (digit < 2) {
            return;
        }
        if (digit < 7) {
            start = (digit - 2) * 3;
            end = start + 3;
        } else if (digit == 7) {
            start = (digit - 2) * 3;
            end = start + 4;
        } else if (digit == 9) {
            start = 22;
            end = start + 4;
        } else {
            start = 19;
            end = start + 3;
        }
        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            phonePad(p + ch, up.substring(1));
        }
    }
}
