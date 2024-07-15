public class CommaCounter {

    public static int findCommas(int N) {
        int commaCount = 0;

        for (int i = 1; i <= N; i++) {
            commaCount += countCommas(i);
        }

        return commaCount;
    }

    private static int countCommas(int num) {
        String numStr = String.valueOf(num);
        int length = numStr.length();
        // No commas needed for numbers with less than 4 digits
        if (length <= 3) {
            return 0;
        }

        // Calculate the number of commas based on length of the number
        // 1 comma for numbers with 4-6 digits
        // 2 commas for numbers with 7-9 digits
        // 3 commas for numbers with 10-12 digits, and so on
        return (length - 1) / 3;
    }

    public static void main(String[] args) {
        int input1 = 1010;
        int result = findCommas(input1);
        System.out.println(result);  // Output: 11
    }
}
