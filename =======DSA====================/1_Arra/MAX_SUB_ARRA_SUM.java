import java.util.HashSet;

public class MAX_SUB_ARRA_SUM {
    public static void main(String args[]){
        int marks[]={-2,-3,-4,-1,-2,-1,-5,-3};
        System.out.println("ur  values are");
        for(int i=0;i<marks.length;i++)
        System.out.print(marks[i]+" ");
        System.out.println();
        // pairs(marks);
        // System.out.println(kadanes(marks));
        kadanes(marks);

        
        
        
    }
    //PAIRS AND MAX SUM ARE ALMOST THE SAME
    public static void pairs(int marks[]){
        int count=0,maxlen=0;
        int csum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<marks.length;i++){
            int current=marks[i];
            for(int j=i;j<marks.length;j++){
                csum=0;
                for(int k=i;k<=j;k++){
                    // System.out.print(marks[k])
                    csum += marks[k];

                }
                if(maxsum<csum){
                    maxsum=csum;
                }
                count++;
                //its the subarray Sum from left to right
                System.out.print(csum);
                System.out.print(" ") ;
                
            }
            System.out.println( );
            
        }
        System.out.println(count);
        System.out.println(maxsum) ;

    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE, sum = 0;
    
            for (int num : nums) {
                sum += num;
    
                max = Math.max(sum, max);
    
                if (sum < 0) {
                    sum = 0;
                }
            }
            
            return max;
        }
    }

    public static int kadanes(int marks[]){
        int currsum = 0, maxsum = Integer.MIN_VALUE,mincurr=Integer.MIN_VALUE;
        for (int i = 0; i < marks.length; i++) {
                currsum += marks[i];
            if(currsum<0){
                if(mincurr<currsum) mincurr=currsum;
                currsum=0;

            }
            else{
                if (maxsum < currsum) {
                    maxsum = currsum;
                }
            }

        }
        return maxsum<0?mincurr:maxsum;
    } 

    //prfix Sum
       public int  M2subarraysDivByK(int[] marks, int k) {
        int count=0,maxlen=0;
        int ans=0;
       int csum=0;
       int maxsum=Integer.MIN_VALUE;
           int prefix[]=new int[marks.length];
           prefix[0]=marks[0];
           for(int i=1;i<prefix.length;i++){
               prefix[i]=prefix[i-1]+marks[i];
           }
       for(int i=0;i<marks.length;i++){
           int current=marks[i];
           for(int j=i;j<marks.length;j++){
               csum=0;
               csum=i==0?prefix[j]:prefix[j]-prefix[i-1];
               if(maxsum<csum){
                   maxsum=csum;
               }
               count++;
               //its the subarray Sum from left to right
               if((csum%k==0)){
                   ans++;
               }
               // System.out.print(csum);
               // System.out.print(" ") ;
               
           }
           System.out.println( );
          
       }
       // System.out.println(ans);
       return ans;
       // System.out.println(maxsum) ;

   }
   


   //subarray divisible by K in O(n+K)
   public int subarraysDivByK(int[] nums, int k) {
    int n = nums.length;
    int prefixMod = 0, result = 0;

    // There are k mod groups 0...k-1.
    int[] modGroups = new int[k];
    modGroups[0] = 1;

    for (int num: nums) {
        // Take modulo twice to avoid negative remainders.
        prefixMod = (prefixMod + num % k + k) % k;
        // Add the count of subarrays that have the same remainder as the current
        // one to cancel out the remainders.
        result += modGroups[prefixMod];
        modGroups[prefixMod]++;
    }

    return result;
}
}
 