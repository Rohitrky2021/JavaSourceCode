import java.util.Collection;

public class Oct1 {
    public String reverseWords(String s) {
        StringBuilder ss=new StringBuilder(s);
        String ar[]=s.split(" ");
      

        for(StringBuilder i:ar){
            StringBuilder m=new StringBuilder(i);
            ss.append(m.reverse()+" ");
        }
      
        return  ss.toString().trim();

        
    }
}
