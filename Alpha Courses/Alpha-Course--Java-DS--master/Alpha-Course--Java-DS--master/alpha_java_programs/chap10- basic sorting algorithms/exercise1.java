//WAP on bubble sort algorithm to sort the array [3,6,2,1,8,7,4,5,3,1] in descending order
public class exercise1 {
    //to sort the array which is in the main function
    public static void bubblesorting(int arr[]) {
        for(int turn=0; turn<arr.length-1; turn++) {
            for(int j=0;j<arr.length-1-turn;j++) {
                if(arr[j] < arr[j+1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    //to print the array which is sorted
    public static void printarray(int arr[]) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        bubblesorting(arr);
        printarray(arr);
    }
}
