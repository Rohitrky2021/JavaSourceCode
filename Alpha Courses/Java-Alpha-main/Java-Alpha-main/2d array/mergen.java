import java.util.Arrays;
public class mergen {
   public static void arraymerge(int[] num1 ,int[] num2 ,int x ,int y){
    int col[] = new int[num1.length];
    int k=0;

    for(int i=0,j=0;i+j<x+y-1;){
        if(num1[i] < num2[j]){
            col[k] = num1[i];
            if(i < x){
                i++;
            }
        }else if(num1[i] > num2[j]){
            col[k] = num2[j];
            if(j < y){
                j++;
            }   
        }
        k++;
    }
    
    if(num1[x-1]>num2[y-1]){
        col[num1.length-1] = num1[x-1];
    }else{
        col[num1.length-1] = num2[y-1];
    }

    for(int i = 0; i<col.length;i++){
        num1[i] = col[i];
    }

    
   } 
    public static void main(String[] args) {
        int num1[] = {2,0};
        int num2[] = {0};
        int x = 1;
        int y =0; 

        arraymerge(num1,num2,x,y);
        for(int i =0; i< num1.length ; i++){
            System.out.print(num1[i]);
        }
    }
}
