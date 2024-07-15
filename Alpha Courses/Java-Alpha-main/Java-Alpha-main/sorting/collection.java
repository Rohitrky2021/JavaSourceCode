
public class collection {

    public static void collection_sort(int arr[]) {
        int max = Integer.MIN_VALUE;
        // range
        for(int i = 0 ; i<arr.length ;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
         int coll[]= new int[max+1];
        //frequency
        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            coll[temp] += 1; 
        }
        //sorting
        int count=0;
        for(int i = 0;i<coll.length;i++){
            for(int j=0;j<coll[i];j++){
                arr[count]=i;
                count++;
            }
        }
        print(arr);
    }
    public static void print( int arr[]) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }        
}

public static void main(String[] args) {
    int arr[]={1,4,1,3,2,4,3,7};
    collection_sort(arr);
}
}
