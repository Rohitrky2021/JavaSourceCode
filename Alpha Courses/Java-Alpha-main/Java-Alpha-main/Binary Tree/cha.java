public class cha {
    public static void main(String[] args) {
        String s[] = {"2A","3B","3C"};  
        for(int j = 0 ; j < s.length; j++){
        int sum=0; 
        for(int i=0; i <s[j].length()-1; i++){
            char x = s[j].charAt(i);
            if(x-'0' >= 0 && x-'0' <= '9'){
                sum *= 10;
                sum += x-'0';
            }        
        }
        for(int i = 0 ; i<sum ;i++){
            System.out.print(s[j].charAt(s[j].length()-1));
        }
        System.out.println();
    }
    }
}
