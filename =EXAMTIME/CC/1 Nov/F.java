import java.util.Scanner;

public class F {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        int caseIndex = 0;
        while (caseIndex < testCases) {
            int numRows = scanner.nextInt();
            int numColumns = scanner.nextInt();
            int infectedCellX = scanner.nextInt();
            int infectedCellY = scanner.nextInt();
            isSorted(new int[]{1,2,3,4});
            int maxVaccinatedCellsHorizontal = Math.max(numRows * numColumns - infectedCellX * numColumns, numRows * numColumns - (numRows - infectedCellX + 1) * numColumns);
            int maxVaccinatedCellsVertical = Math.max(numRows * numColumns - infectedCellY * numRows, numRows * numColumns - (numColumns - infectedCellY + 1) * numRows);

            int maxVaccinated = Math.max(maxVaccinatedCellsHorizontal, maxVaccinatedCellsVertical);

            System.out.println(maxVaccinated);

            caseIndex++;
        }
        scanner.close();
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
