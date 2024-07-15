
public class insertion {
    // 3,4,5,6,1,2
    public static void insertion_sort( int arr[]) {
        for(int i=1;i<arr.length;i++){
            int j=i;
             int temp = arr[i];
            while(j>0 && temp<arr[j-1]){    
                arr[j]=arr[j-1];
                j--;                       
            }
            arr[j]=temp;       
        }
        print(arr);      
    }
    public static void print( int arr[]) {
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]);
            }        
    }
    public static void main(String[] args) {
        int arr[]={3,4,5,6,1,2};
        insertion_sort(arr);
    }   
}
