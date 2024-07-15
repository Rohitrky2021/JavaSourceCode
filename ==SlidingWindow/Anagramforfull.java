import java.util.Arrays;
import java.util.List;

public class Anagramforfull {
    public List<Integer> findAnagrams(String s, String p) {
        char pi[]=p.toCharArray();
        cahr si[]=s.toCharArray();
        int hash[] = new int[26];// for baap 
        int curr[]  = new int[26];// my winodw array 
         
        List<Integer>ans = new LinkedList<>();

        int tail=0,anss=0,sum=0,targetsum=k,head/*makeing it global */;

        for (int i = 0; i < pi.length; i++) {
            hash[pi[i]-'a']++;
        }


        for (head = 0; head < arr.length; head++) {
           if(Arrays.compare(hash, curr))ans.add(tail);
            sum=sum+arr[head];
            while(head-tail+1>p.length()){
                curr[si[tail]-'a']--;
                tail++;
            }
            curr[si[tail]-'a']--;
            
        }
        if(Arrays.compare(hash, curr))ans.add(tail);
        // return head-tail+1;
        return ans;
             
    }
}
