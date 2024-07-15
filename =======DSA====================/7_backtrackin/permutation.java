public class permutation {
    public static void main(String args[]){
        String str="abc";
        String ans="";
        perm(str, ans);
        
    }
    public static void perm(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
            
        }
        for (int i=0;i<str.length(); i++) {
            char curr=str.charAt(i);
            String newstr=str.substring(0,i)+str.substring(i+1);  // all word string without the Curr one 
            // System.out.println( newstr);
 
            perm(newstr,ans+curr);
        }
    }
}
