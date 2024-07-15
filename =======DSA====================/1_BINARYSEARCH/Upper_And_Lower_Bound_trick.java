import java.util.Arrays;
public class Upper_And_Lower_Bound_trick {
    
}

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 4, 4, 6, 7, 8};

        int key = 4;

        int lowerBound = Arrays.binarySearch(array, key);
        int upperBound = lowerBound;

        if (lowerBound < 0) {
            lowerBound = -(lowerBound + 1);
        }

        while (upperBound < array.length && array[upperBound] == key) {
            upperBound++;
        }

        System.out.println("Lower Bound: " + lowerBound);
        System.out.println("Upper Bound: " + (upperBound - 1));
    }
}
