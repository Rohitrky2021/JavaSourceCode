import java.util.Scanner;

public class weight {
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T =sc.nextInt();
        while(T-->0){
            int W=sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();
            int z=sc.nextInt();
            if(W==x+y||W==x+z||W==x+y+z||W==x||W==y||W==z){
                System.out.println("YES");

            }
            else{
                System.out.println("NO");
            }
            



        }
    }
}
