public class fibonacci {
    public static void main(String args[]){
    //    System.out.println(fib(7)); 
    fib2(0, 1, 7);
    int arr[]={1,2,3,4,5,6,2,8,9};
    System.out.println(issort(arr, 0)); 
    System.out.println(fo(arr, 10, 0)); 
    System.out.println(lastoccur(arr, 2, 0));
    
}
static int ans=0;

public static void fib2(int a,int b,int n) {
    if(n==0){
        return; 
    }

    int c=a+b;

    System.err.println(c);
    fib2(b, c, n-1);
    System.err.println(c);

  
}
public static long fib(long  x){
        // if(x==0){
        //     return 0;
        // }
        // if(x==1){
        //     return 1;
        // }
        if(x==0 || x==1){
            return x;
        }
        else{
            ans+=x;
            System.out.println(ans);
            return fib(x-1)+fib(x-2);
        }

    }
    
    public static boolean issort(int arr[],int x){
        if(x==arr.length-1){
            return true;
        }
        if(arr[x]>arr[x+1]){
            return false;
        }
        return issort(arr, x+1);
    }
    public static boolean fo(int arr[],int key,int i){//first occurence of a character
        // int i=0;
        if(i>arr.length-1){
           System.out.println("SORRRY NO KEY FOUND"); // break;
            return false;//BASE CASE ALWAYS UP HERE
        }
        if(arr[i]==key){
            System.out.println(i);
            return true;
        }
        return fo(arr, key,i+1);
    }



    public static int lastoccur(int arr[],int key,int i){//first occurence of a character
       if(i==arr.length){
        return -1;
       }
       int isfound=lastoccur(arr, key, i+1);
       if(isfound==-1 && arr[i]==key){
        return i;
       }
    //    if(arr[i]==key){
    //     return i;
       
       return isfound;

    }

    

}
     