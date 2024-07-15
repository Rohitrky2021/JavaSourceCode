public class roateted {
    public static int search(int arr[],int si,int ei,int tar) {
        if(si>ei){
            return -1;
        }
        //work
        int mid = si+(ei-si)/2;
        if(arr[mid]==tar){
            return mid;
        }

        if(arr[si] <= arr[mid]){
            if(arr[si] <= tar && tar <=arr[mid]){
                return search(arr, si, mid-1, tar);
            }else{
                return search(arr, mid+1, ei, tar);
            }

        }else{
            if(arr[mid] <= tar && tar <= arr[ei]){
                return search(arr, mid+1, ei, tar);
            }else{
                return search(arr, si, mid-1, tar);
            }
        } 
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0; 
        System.out.println(search(arr, 0, arr.length-1, target));
    }
}
