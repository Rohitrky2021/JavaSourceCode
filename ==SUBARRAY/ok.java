public class ok {

    public static void main(String[] args) {
        int steps = 4;
        int badIndex = 6;
        int result = calculateMaxIndex(steps, badIndex);
        System.out.println("The maximum index that can be reached is: " + (-2%3));
    }

    static int calculateMaxIndex(int steps, int badIndex) {
        int currentIndex = 0;
        int jump = 1;
        boolean isValidSequence = true;

        for (int i = 0; i < steps; i++) {
            if (currentIndex + jump == badIndex) {
                // Skip the bad index by making a smaller jump
                jump = 2;
                currentIndex = 0;
                i=1;
            }

            currentIndex += jump;
            jump++;
        }

        if (isValidSequence) {
            return currentIndex;
        }

        return -1;
    }
}
