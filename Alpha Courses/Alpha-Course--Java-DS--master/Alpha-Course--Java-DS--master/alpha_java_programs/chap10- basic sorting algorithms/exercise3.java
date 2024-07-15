//WAP on insertion sort algorithm to sort the array [3,6,2,1,8,7,4,5,3,1] in descending order
public class exercise3 {
    public static void insertionsorting(int arr[]) {
        for(int i=1; i<arr.length; i++) {
            int curr = arr[i];
            int prev = i-1;
            //finding out the correct position to insert
            while(prev >=0 && arr[prev] < curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            //insertion
            arr[prev+1] = curr;
        }
    }
    //to print the array which is sorted
    public static void printarray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        insertionsorting(arr);
        printarray(arr);
    }
}
