import java.util.Arrays;
import java.util.Comparator;

// WAP to implement maximum length chain of pairs in greedy algorithms
// time complexity is O(nlogn)
public class maxlengthchainofpairs {
    public static void main(String[] args) {
        int pairs[][] = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int chainEnd = pairs[0][1]; //last selected pair end - chair end
        for(int i=1; i<pairs.length; i++) {
            if(pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("max length of chain= "+chainLen);
    }
}
