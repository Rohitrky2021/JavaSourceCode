import java.util.Arrays;
// Our Pivot will be the last element

public class QuickSort {
    public static void main(String[] args) {
        int arr[]={6,3,9,5,2,8};
        // change(arr);
        // swap(arr,0,1);
        QuicKSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        
        
    }
    static int  partition(int arr[],int low,int high){
        int pivot=arr[high];
        System.out.println("pivot-->"+pivot);
        int i=low-1;

        for (int j = low; j < high; j++) {
            if(arr[j]<pivot){
                i++;
                //swap
                swap(arr, i, j);
            }
        }
        i++;
        // last swap for pivot-->Putting Back pivot at Right Place again ;
        swap(arr, i, high);
        System.out.println(i);
        return i;//pivot Index;;


    }

    static void QuicKSort(int arr[],int low ,int high){
        if(low<high){
            int pidx=partition(arr, low, high);//pivot Index;
        QuicKSort(arr, low, pidx-1);
        QuicKSort(arr, pidx+1, high);

        }
    }
    static void swap(int arr[],int x,int y){
        
        arr[x] = arr[x] + arr[y];
		arr[y] = arr[x] - arr[y];
		arr[x] = arr[x] - arr[y];
    }


}
