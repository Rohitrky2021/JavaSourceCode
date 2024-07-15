import java.util.*;
public class B_18 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
       
        while(T-->0){
            int R=sc.nextInt();
            int C=sc.nextInt();
            
            String  tree[][]=new String[R][C];
            
            
            for (int i = 0; i<R; i++) {
                for(int j=0;j<C;j++) {
                    tree[i][j]=sc.next();
                  
                    }
                }
                
                if((R==1||C==1)&& !notree(tree) ){
                    System.out.println("impossible");
                }
                if(notree(tree)){
                    System.out.println("possible");
                    for (int i = 0; i<R; i++) {
                        for(int j=0;j<C;j++) {
                            System.out.print(tree[i][j]+" ");
                        }
                        
                    }
                }
                else{
                    System.out.println("possible");
                    for (int i = 0; i<R; i++) {
                        for(int j=0;j<C;j++) {
                            System.out.print("^"+" ");
                        }
                        System.out.println();
                        
                    }
                }
            
    }
}
public static Boolean notree(String tree[][]){
    for (int i = 0; i < tree.length; i++) {
        for(int j=0;j<tree[0].length;j++){
            if("^".equalsIgnoreCase(tree[i][j])){
                return false;
            }
        }
    }
    return true;
}
}
