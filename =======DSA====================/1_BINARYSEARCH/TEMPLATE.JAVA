import java.util*;

public class BINARYSEARCH{
    public static void main(String[] args) {
        int l = 0;
        int r = arr.length - 1;
        int mid = l + (r - l) / 2;
        while (l <= r) {
            if (arr[mid] > arr[mid + 1]) {
                r = mid-1;
            } else {
                l = mid + 1;
            }

            mid = l + (r - l) / 2;
        }
        System.out.println(l+" "+r);
        return l;
        
        
    }
}