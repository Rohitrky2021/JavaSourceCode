import java.util.*;
public class Non {
    public static void nonrepeat(String str){
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];
       
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty()){
                int a = q.peek();
                if(freq[a-'a']==1){
                    break;
                }else{
                    q.remove();
                }
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        nonrepeat(str);
    }
}
