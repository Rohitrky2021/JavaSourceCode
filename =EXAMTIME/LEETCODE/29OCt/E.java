public class E {
    
}

 
public long minIncrementOperations(int[] roh, int k) {
    long totalOperations = 0;
    int n = roh.length;
    int i = 0;
      isSorted(roh);
    
    while (i < n - 2) {
        long maxInTriplet = Math.max(roh[i], Math.max(roh[i + 1], roh[i + 2]));
        if (maxInTriplet < k) {

            long increment = k - maxInTriplet;
            roh[i] += increment;
            roh[i + 1] += increment;
            roh[i + 2] += increment;
            totalOperations += increment;
        }
        i++;
    }
    isSorted(roh);

    return totalOperations;
}
public  boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
  }

