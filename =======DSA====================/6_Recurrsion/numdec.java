public class numdec {
    public static void main(String args[]){
        printdecM2(10);

    }


public static void printdec(int x){
    // System.out.println(x+ printdec(x-1));
    if (x==1){
        System.out.println(x);
    }
    else{
        System.out.println(x);
        printdec(x-1);
    }

}

public static void printdecM2(int x){
    // System.out.println(x+ printdec(x-1));
    if (x==1){
        System.out.println(x);
        return;}

        System.out.println(x);
        printdec(x-1);
    }

    
public static void printInc(int x){
    if (x==1){
        System.out.println(1);
        return;}
 
    printInc(x-1);
    System.out.println(x);
    }
}

