//WAP to print the number of 7's that are in the 2D array
public class exercise1 {
    public static void main(String[] args) {
    int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int count = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (array[i][j] == 7) {
          count++;
        }
      }
    }
    System.out.println("Number of 7's: " + count);
    }
}
