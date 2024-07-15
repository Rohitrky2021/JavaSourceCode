
public class selection {
    public static void selection_sort(int arr[]) {
        for(int i = 0 ;i < arr.length-1;i++){
            int min = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min= j;
                }
            }
            int temp = arr[min];
                arr[min]=arr[i];
                arr[i]=temp;
       }
        print(arr);
    }
    public static void print( int arr[]) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }        
}

public static void main(String[] args) {
    int arr[]={4,3,5,6,1,2};
    selection_sort(arr);
}

}
