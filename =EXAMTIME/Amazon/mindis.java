import java.util.Arrays;
import java.util.List;

class mindis {

    static long getMinDistance(List<Integer> center, List<Integer> destination) {
        // Convert lists to arrays
        Integer[] centerArray = center.toArray(new Integer[0]);
        Integer[] destinationArray = destination.toArray(new Integer[0]);

        // Sort both arrays
        Arrays.sort(centerArray);
        Arrays.sort(destinationArray);

        // Calculate total lag
        long totalLag = 0;
        for (int i = 0; i < centerArray.length; i++) {
            totalLag += Math.abs(centerArray[i] - destinationArray[i]);
        }

        return totalLag;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> center = List.of(4,6);
        List<Integer> destination = List.of(5,5);
        System.out.println(getMinDistance(center, destination));
    }
}
