public class pair {
    public static int pairway(int n){
        if(n==1 || n==2){
            return n;
        }
        return pairway(n-1) + (n-1)*pairway(n-2);
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.print(pairway(n));

    }
}
