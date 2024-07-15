import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Window30 {
    public static void main(String[] args) {
        
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int wl=words[0].length();
        int wordn=words.length*wl;
        int sn=s.length();
        List<Integer> arr=new ArrayList<>();

        if(s==0||wordn==0){
            return new ArrayList<>();
        }

        var frequencyMap=new HashMap<String,Integer>();

        for(String i:words){
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0)+1);
        }
        
        
        for (int i = 0; i <s.length()-wordn; i++) {
            
            var curr=new HashMap<String,Integer>();
            for (int j = 0; j < wl; j++) {

                int subind=i+j*wl;
                
                var subs=s.substring(subind, subind+wl);

                if(!frequencyMap.containsKey(subs)){
                    break;
                }

                curr.put(subs, curr.getOrDefault(subs, 0)+1);

                if(curr.get(subs)>frequencyMap.get(subs)){
                    break;
                }
                if(j-i+1==wordn){
                    arr.add(i);
                }

                return arr.

                
            }

        }
        
    }
}
    

