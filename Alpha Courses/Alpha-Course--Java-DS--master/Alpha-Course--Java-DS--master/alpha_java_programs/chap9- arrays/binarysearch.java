//WAP to search an element in an array using binary search
public class binarysearch {
    public static int binary(int numbers[], int key) {
        int start = 0, end = numbers.length-1;
        while(start<=end) {
            int mid = (start+end)/2;
            //comparisons
            if(numbers[mid] == key) { //found
                return mid;
            }
            if(numbers[mid] < key) { //left
                start = mid + 1;
            } 
            else {
                end = mid -1; //right
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int numbers[] = {2,4,6,8,10,12,14};
        int key = 10;
        System.out.println("index for key is: " +binary(numbers, key));
    }
}
