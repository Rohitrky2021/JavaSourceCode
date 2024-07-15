package T01_Arrays;

public class A06_subArray {
    static void printSubArrays(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int j2 = i; j2 <= j; j2++) {
                    System.out.print(arr[j2] + " ");
                }
                System.out.println();
            }
        }
    }
}
