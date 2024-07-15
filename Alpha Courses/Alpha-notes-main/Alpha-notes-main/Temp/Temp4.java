package Temp;

public class Temp4 {
    public static void printLeader(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i = arr.length-1; i >= 0; i--){
            if(max < arr[i]){
                System.out.println(arr[i]);
                max = arr[i];
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {29, 27, 1, 23, 15, 12};
        printLeader(arr);
    }
}
