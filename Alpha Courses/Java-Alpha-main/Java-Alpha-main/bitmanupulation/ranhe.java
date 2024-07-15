public class ranhe {
    public static int  range(int a,int i,int j) {
        int x = (~0)<<(j+1);
        int y = (1<<i)-1;
        return (x|y)&a;
    }
    public static void main(String[] args) {
        int a = 10;
        int i =2;
        int j = 4;
        System.out.println(range(a,i,j));

    }
    
}
