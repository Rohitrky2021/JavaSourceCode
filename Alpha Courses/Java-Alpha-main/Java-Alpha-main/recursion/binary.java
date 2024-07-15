public class binary {
    public static void binaryprint(int n, int lp , String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        if(lp==0){
            binaryprint(n-1,0, str+"0");
            binaryprint(n-1,1, str+"1");
        }else{
            binaryprint(n-1,0, str+"0");
        }
    }
    public static void main(String[] args) {
        int n =3;
        String str = new String("");

        binaryprint(n,0,str);
    }
    
}
