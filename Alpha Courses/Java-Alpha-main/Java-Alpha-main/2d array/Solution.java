public class Solution {
    private static void median(int[] num1, int[] num2) {
        int n = num1.length +num2.length;
        int arr[] = new int[n];
        // 1 3    2 
        int p1 =0, p2=0 ;  
        for(int i = 0 ; i < n;i++){
            
            if(p1 < num1.length && p2 < num2.length){
                if(num1[p1] < num2[p2]){
                    arr[i] = num1[p1];
                    p1++;
                }else{
                    arr[i] =num2[p2];
                    p2++;
                }
            }else if(p1 < num1.length){
                arr[i] = num1[p1];
                    p1++;
            }
            else if(p2 < num2.length ){
                arr[i] =num2[p2];
                    p2++;
            }
        }
        printarr(arr);

       
    }



    public static void printarr(int [ ] arr) {
        for(int i =0 ; i < arr.length ; i++){
            System.out.print(arr[i]+ " ");
        }
    }
    public static void main(String[] args) {
        int num1[] = {1,3};
        int num2[] = {2};

        median(num1,num2);



     }

    
}
