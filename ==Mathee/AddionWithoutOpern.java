public class AddionWithoutOpern {

    // For future Revision--> https://www.youtube.com/watch?v=gVUrDV4tZfY

    public int getSum(int a, int b) {
        while (b != 0) { // as jub tuk Carry aana bund na ho jaaye 
            int carry = (a&b) << 1;
            a = a^b;
            b = carry;

        }
        return a;

    }
}
