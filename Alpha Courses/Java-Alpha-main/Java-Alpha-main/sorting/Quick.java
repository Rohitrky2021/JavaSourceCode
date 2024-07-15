
public class Quick {
    public static void printarr(int arr[]) {
        for(int i = 0 ; i< arr.length ;i++){
            System.out.print(" "+ arr[i]);
        }
    }
    public static void quicksort(int[] arr, int st, int en) {
        if(st>=en){
            return;
        }
        //last element 
        int inpiv = partion(arr,st,en);
        quicksort(arr, st, inpiv-1);
        quicksort(arr, inpiv+1, en);
    }
    private static int partion(int[] arr, int st, int en) {
        int pivt = arr[en];
        int i = st-1;

        for(int j=st; j < en ;j++ ){
            if(arr[j]<= pivt){
                i++;
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivt;
            arr[en]=arr[i];
            arr[i] = temp;
        return i;
    }
    public static void main(String[] args) {
        int arr[] = {6,3,9,8,2,5};
        quicksort(arr,0,arr.length-1);
        printarr(arr);

    }
    
}
