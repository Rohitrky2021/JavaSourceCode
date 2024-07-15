//WAP to remove duplicates from a string
public class removeduplicate {
    public static void noduplicate(String str, int idx, StringBuilder newstring, boolean map[]) 
    {
        //base case
        if(idx == str.length()) {
            System.out.println(newstring);
            return;
        }

        //working
        char currchar = str.charAt(idx);
        if(map[currchar = 'a'] == true) {
            //duplicate
            noduplicate(str, idx+1, newstring, map);
        }

        else {
            map[currchar - 'a'] = true;
            noduplicate(str, idx+1, newstring.append(currchar), map);
        }

    }
    public static void main(String[] args) {
        String str = "karansanghvi";
        noduplicate(str, 0, new StringBuilder(""), new boolean[26]);
    }
}