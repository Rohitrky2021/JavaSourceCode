public class tiling {
    public static void main(String args[]){
        System.out.println(tiling(4)); 
        
    }
    public static int tiling(int n){
        if(n==0||n==1){
            return 1;
        }
        int v=tiling(n-1);
        int h=tiling(n-2);
        return v+h;
    }
}//for 4*n also it will same;
 