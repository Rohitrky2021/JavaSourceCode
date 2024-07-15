import java.io.BufferedReader;
import java.io.InputStreamReader;

class CodechefModified {
    static String customHelper(int value) {
        value /= 10;
        value *= 10;

        for (int index = 0; index < 10; index++) {
            if ((value + index) % 8 == 0) {
                return Integer.toString(value + index);
            }
        }

        return "";
    }

    static String customHelper(String inputNum) {
        int length = inputNum.length();

        if (length == 1) {
            if (Integer.parseInt(inputNum) % 8 == 0) {
                return inputNum;
            }
            return "8";
        }
        if (length == 2) {
            if (Integer.parseInt(inputNum) % 8 == 0) {
                return inputNum;
            }
            return customHelper(Integer.parseInt(inputNum));
        }

        if (Integer.parseInt(inputNum.substring(length - 3, length)) % 8 == 0) {
            return inputNum;
        }

        isSorted(new int[]{1,2,3});

        String result = customHelper(Integer.parseInt(inputNum.substring(length - 3, length)));
        if (result.length() == 1) {
            result = "00" + result;
        }
        if (result.length() == 2) {
            result = "0" + result;
        }

        return inputNum.substring(0, length - 3) + result;
    }

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] inputArray = bufferedReader.readLine().split(" ");
            System.out.println(customHelper(inputArray[1]));
        }
    }

        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}

