public class heep {

public class heapsort {

    public static void heapify(int[] arr , int i ,int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int mdx = i;

        if(left < size && arr[left] > arr[mdx]){
           mdx = left; 
        }
        if(right < size && arr[right] > arr[mdx]){
            mdx = right; 
         }

         if(mdx !=i){
            int temp = arr[i];
            arr[i] = arr[mdx];
            arr[mdx] =temp;

            heapify(arr, mdx, size);
         }
    }

    public static void Heapsorta(int[] arr, int n){
        for(int i=n/2 ; i>=0;i--){
            heapify(arr,i,n);
        }

        // to push largest at end
        for(int i = n-1 ; i >0 ;i--){
            //swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr,0,i);
        }
    }



    public static void main(String[] args) {
        int arr[] = {1,2,4,5,3};
        Heapsorta(arr,arr.length);
        for(int i = 0 ;i < arr.length ; i++){
            System.out.println(arr[i]);
        }

    }
}
}