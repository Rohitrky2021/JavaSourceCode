// import java.util.ArrayList;
// import java.util.List;

// public class F {
//     public static void main(String[] args) {
//         int num = 161;

//         String binaryString = Integer.toBinaryString(num);
//         char[] binaryCharArray = binaryString.toCharArray();
//         int[] binaryIntArray = new int[binaryCharArray.length];

//      List<Integer> setBitIndices = new ArrayList<>();

//         for (int i = 0; i < binaryCharArray.length; i++) {
//             binaryIntArray[i] = Character.getNumericValue(binaryCharArray[i]);
//             if (binaryIntArray[i] == 1) {
//                 setBitIndices.add(i+1);
//             }
//         }
//         setBitIndices.add(0,setBitIndices.size());

//         System.out.println( setBitIndices);
//     }
// }


import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class F {
    public static void main(String[] args) {
        int num = 161;

        // Convert the number to binary string
        String binaryString = Integer.toBinaryString(num);

        // Create a BitSet from the binary string
        BitSet bitSet = new BitSet(binaryString.length());
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                bitSet.set(i);
            }
        }

        // Find the set bit positions (1-based indexing)
        List<Integer> setBitIndices = new ArrayList<>();
        for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
            setBitIndices.add(i + 1);
        }

        // Add the size of the list at index 0
        setBitIndices.add(0, setBitIndices.size());

        System.out.println(setBitIndices);
    }
}
