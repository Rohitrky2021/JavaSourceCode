//WAP on selection sort algorithm
public class selectionsort {
    public static void selectionsorting(int arr[]) {
        for(int i=0;i<arr.length-1;i++) {
            int minPos = i;
            for(int j=i+1;j<arr.length;j++) {
                if(arr[minPos]>arr[j]) {
                    minPos = j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }
    //to print the array which is sorted
    public static void printarray(int arr[]) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+"");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        selectionsorting(arr);
        printarray(arr);
    }
}
