import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int length = scanner.nextInt();
            String inputString = scanner.next();

            ArrayList<Integer> positions = new ArrayList<>();
            int operations = 0;

            if (length % 2 == 1) {
                System.out.println("-1");
              
            } else {
                while (operations < 300) {
                    int middle = inputString.length() / 2;
                    int end = inputString.length();
                    int leftIndex = -1;
                    int foundMatch = 0;
                    char leftChar = '0';
                    int rightIndex = -1;
                    
                    int k = 0;
                    while (k < middle) {
                        if (inputString.charAt(k) == inputString.charAt(end - k - 1)) {
                            leftIndex = end - k - 1;
                            rightIndex = k;
                            leftChar = inputString.charAt(k);

                            if (leftChar == '0') {
                                positions.add(leftIndex + 1);
                            } else {
                                positions.add(rightIndex);
                            }

                            foundMatch = 1;
                            break;
                        }
                        k++;
                    }
                  
                    if (foundMatch == 0) {
                        break;
                    } else {
                        if (leftChar == '0') {
                            inputString = inputString.substring(0, leftIndex + 1) + "01" + inputString.substring(leftIndex + 1);
                        } else {
                            inputString = inputString.substring(0, rightIndex) + "01" + inputString.substring(rightIndex);
                        }
                    }

                    operations++;
                }
  
                if (operations == 300) {
                    System.out.println("-1");
                } else {
                    System.out.println(operations);
                    for (int i = 0; i < positions.size(); ++i) {
                        System.out.print(positions.get(i) + " ");
                    }
                    System.out.println();
                }
            }
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
    public static boolean isSorted(ArrayList<Integer> arrayList) {
        int n = arrayList.size();
        for (int i = 0; i < n - 1; i++) {
            if (arrayList.get(i) > arrayList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    

}
