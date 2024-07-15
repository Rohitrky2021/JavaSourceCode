public class tiling {
    public static void removedup(String str,int i, StringBuilder sb,boolean map[]){
    if(i==str.length()){
        System.out.println(sb);
        return;
    }
    char newchar = str.charAt(i);
    if(map[newchar-'a']==true){
        removedup(str, i+1, sb, map);
    }else{
        map[newchar-'a']=true;
        removedup(str, i+1, sb.append(newchar), map);
    }   
    }
    public static void main(String[] args) {
        String str = "rishabhrathore";
        boolean map[] = new boolean[26];
        StringBuilder sb = new StringBuilder("");
        int  i = 0;
        removedup(str, i, sb, map);       
    }
}
