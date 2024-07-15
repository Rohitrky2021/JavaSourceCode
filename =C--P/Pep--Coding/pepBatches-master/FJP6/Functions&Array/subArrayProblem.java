import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        subArrayProblem(arr);
    }

    public static void subArrayProblem(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i ; j < arr.length ; j++){

                for(int idx = i ; idx <= j ; idx++){
                    System.out.print(arr[idx]+"\t");
                }
                System.out.println();
                
            }
        }
    }

}