public class removedupli {
    public static void main(String args[]){
        // String pass=new String("appnaboss");
        String pass="roohhiiht";
        removeduplicate(0, new StringBuilder(""),new boolean [36], pass);

    }

    public static void removeduplicate(int i/*index */,StringBuilder arr,boolean map[],String pass){

        if(i==pass.length()){
            System.out.println(arr);
            return; 
        }
        char curr=pass.charAt(i);

        if(map[curr-'a'] ==  true){
            removeduplicate(i+1, arr, map, pass);
        }
        else{
            map[curr-'a']=true;
            removeduplicate(i+1, arr.append(curr), map, pass);
        }
        
    }

// *****************IMP*********************

// to store  the count one occur or not in the  best manner 
public class DuplicateCharacters {
    public static void findDuplicates(String str) {
        int checker = 0;
        int length = str.length();

        for (int i = 0; i < length; i++) {
            int charValue = str.charAt(i) - 'a'; // Assuming the string only contains lowercase alphabets
            int mask = 1 << charValue;

            if ((checker & mask) > 0) {
                System.out.println("Duplicate character found: " + str.charAt(i));
            } else {
                checker |= mask;  //  storing in ans for the anotherc check
            }
        }

        System.out.println("No duplicate characters found.");
    }

    public static void main(String[] args) {
        String input = "Hello World!";
        findDuplicates(input);
    }
}


    
}
