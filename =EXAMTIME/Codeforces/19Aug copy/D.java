import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();  // height of the grid
            int m = sc.nextInt();  // width of the grid
            sc.nextLine();  // consume the remaining newline

            ArrayList<Integer> xCoords = new ArrayList<>();
            ArrayList<Integer> yCoords = new ArrayList<>();

            // Reading the grid and collecting the coordinates of '#'
            for (int row = 0; row < n; row++) {
                String line = sc.nextLine();
                for (int col = 0; col < m; col++) {
                    if (line.charAt(col) == '#') {
                        xCoords.add(row + 1);  // convert to 1-based indexing
                        yCoords.add(col + 1);  // convert to 1-based indexing
                    }
                }
            }

            // Sorting the coordinates
            Collections.sort(xCoords);
            Collections.sort(yCoords);

            // Finding the median
            int centerX = xCoords.get(xCoords.size() / 2);
            int centerY = yCoords.get(yCoords.size() / 2);

            System.out.println(centerX + " " + centerY);
        }
        
        sc.close();
    }
}
