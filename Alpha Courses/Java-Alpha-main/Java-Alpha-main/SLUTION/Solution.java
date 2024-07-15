public class Solution{

    public static int[] intersection(int nums1[],int nums2[]){
        int arr[];
        int i=0,j=0,d=0;
    
        while((i < nums1.length) && (j < nums2.length) ){
            for( i = 0 ; i < nums1.length ; i++){
                for(j = 0 ; j < nums2.length ; j++){
                    if(nums1[i]==nums2[j]){
                        arr[d] = nums1;
                        d++;
                        break;
                    }
                }
            }
        }
        
       return arr;
 }
    public static void main(String[] args) {
        int arr[] = {9,4,9,8,4};
        int arr2[]  = {9,4};
        int ans[] = intersection(arr, arr2);

        for(int i = 0 ; i < ans.length ;i++){
            System.out.print(ans[i] +" ");
        }
        
    }
}