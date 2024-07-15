//WAP to implement merge sort in java
public class mergesort {
    //to print the array
    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public static void merge(int arr[], int si, int ei) {
        // base case
        if(si >= ei) {
            return;
        }

        //working
        int mid = si + (ei - si) / 2;   
        merge(arr, si, mid); //left part
        merge(arr, mid+1, ei); //right part
        mergearray(arr, si, mid, ei);
    }

    public static void mergearray(int arr[], int si, int mid, int ei) {
        // left(0,3) right(4,6) = 3 -> 6-0 +1
        int temp[] = new int[ei-si+1];
        int i = si; //iterator for left part
        int j = mid + 1; //iterator for right part
        int k = 0; //iterator for temp array
        
        //comparing the elements and copying them
        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++; 
                // k++;
            }

            else {
                temp[k] = arr[j];
                j++;
                // k++;
            }
            k++;
        }

        //for left over elements which did not get compared & copied- left part
        while(i <= mid) {
            temp[k++] = arr[i++]; //the temp takes current value of k and increments it
                                  //the arr takes current value of i and increments it 
        }

        //for left over elements which did not get compared & copied- right part
        while(j <= ei) {
            temp[k++] = arr[j++]; //the temp takes current value of k and increments it
                                  //the arr takes current value of i and increments it 
        }

        //copy temp to original array
        for(k=0, i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    //main code
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        merge(arr, 0, arr.length-1);
        printArr(arr);
    }
}