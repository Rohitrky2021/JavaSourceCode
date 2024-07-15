import java.util.HashMap;

public class Erase_MaxValue_1695{
    public static void main(String[] args) {
       
    }

    public int maximumUniqueSubarray(int[] arr) {//using video template 
        int k=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.getOrDefault(key, defaultValue)

         int tail=0,ans=0,sum=0,targetsum=k,head/*makeing it global */;

            for (head = 0; head < arr.length; head++) {
                hm.put(arr[head], hm.getOrDefault(arr[head], 0)+1);
            
                while(hm.getOrDefault(arr[tail], 0) >1){
                    sum=sum-arr[tail];
                    hm.put(arr[head], hm.getOrDefault(arr[head], 0)-1);
                    tail++;
                }
                sum+=  hm.getOrDefault(arr[head], 0) ;
                ans=Math.max(ans, sum);
                
            }
    
            // return head-tail+1;
            return ans;
            
        }
}