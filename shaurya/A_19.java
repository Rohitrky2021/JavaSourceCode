import java.util.*;
public class A_19 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int Tr=sc.nextInt();
            int tree[][]=new int[Tr][2];
            for (int i = 0; i<tree.length; i++) {//fixed for wells
               for(int j=0;j<2;j++) {
                tree[i][j]=sc.nextInt();
            }}


            int W=sc.nextInt();
            int well[][]=new int[W][2];

            for (int i = 0; i<W; i++) {//have to iterate on these
                for(int j=0;j<2;j++){ 
                well[i][j]=sc.nextInt();
            }}
           int ans=0;
            //no. of rows is well= well.length;
            while(Tr-->0){
                for (int i = 0; i < W; i++) {
                int Xw1=well[i][0],Yw1=well[i][1];
                int Xt1=tree[Tr][0],Yt1=tree[Tr][1];

                Double inconvie=Math.pow(Math.abs(Xw1-Xt1), 2) +Math.pow(Math.abs(Yw1-Yt1), 2); 
                   ans+=inconvie;
                }
            }
            System.out.println(ans);
        }
    }
}
