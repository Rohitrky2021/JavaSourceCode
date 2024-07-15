import java.util.*;
public class Ticket{
    public static String getstart(HashMap<String,String> hm){
        HashMap<String,String> re = new HashMap<>();
        for(String key : hm.keySet()){
            re.put(re.get(key), key);
        }
        // key have mumbai
        for(String key : hm.keySet()){
            if(!re.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void jorney(HashMap<String,String> hm , String start){
        while(!hm.isEmpty()){
            System.out.println(start);
            start = hm.remove(start);
        }
        System.out.println(start);
        return;
    }

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("chennai","bengaluru");
        map.put("mumbai", "delhi");
        map.put("goa", "chennai");
        map.put("delhi", "goa");
        String start = getstart(map);
        jorney(map,start);
    }
}