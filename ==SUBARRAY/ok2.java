public class ok2 {

    public static int maxIndex(int steps, int badIndex) {
        // If badIndex is the sum of first k natural numbers, start j from k+1
        int k = (int) (Math.sqrt(1 + 8 * badIndex) - 1) / 2;
        int j = (k * (k + 1)) / 2 == badIndex ? k + 1 : 1;

        int currentIndex = 0;

        for (int i = 1; i <= steps; i++) {
            currentIndex += j;

            // If the current index matches the bad index, increment j to avoid it
            if (currentIndex == badIndex) {
                currentIndex++;
            }

            j++;
        }

        return currentIndex;
    }

    public static void main(String[] args) {
        int steps = 4;
        int badIndex = 6;

        int result = maxIndex(steps, badIndex);
        System.out.println("The maximum index that can be reached is: " + result);
    }
}
