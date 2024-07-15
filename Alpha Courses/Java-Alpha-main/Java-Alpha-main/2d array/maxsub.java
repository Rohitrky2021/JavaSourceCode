public class maxsub {
    // 2 4 6 8 10
    
    public static void prifix(int arr[]) {
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      int prefix[] = new int[arr.length];
      prefix[0]=arr[0];
      for(int i = 1; i<arr.length;i++){
        prefix[i] = prefix[i-1] + arr[i]; 
      }
      for(int i = 0; i<arr.length;i++){
        int current_sum=0;
          for(int j = i;j<arr.length;j++){
          current_sum = i==0 ? prefix[j] : prefix[j]-prefix[i-1];        
          }
            if(current_sum < min){
               min = current_sum;
            }
            if(current_sum > max){
               max = current_sum;
            }
          }
          System.out.println("Maximum sum of sub array is  "+ max);
          System.out.println("Minimum sum of sub array is  "+ min);
      }
    public static void main(String args[]) {
    
      int arr[] = {2,4,6,8,10};    
      prifix(arr);
    } 
}
