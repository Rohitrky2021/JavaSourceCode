package T01_Arrays;

class Arr02_moveZero {

    public static void threeLargest(int arr[]) {
        int k = 0;
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] != 0){
                arr[k] = arr[i];
                k++;
            }
        }

        while(k < arr.length){
            arr[k] = 0;
            k++;
        }
    }
    public static void threeLargest2(int arr[]) {
        int k = 0;
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k++;
            }
        }
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 8, 13, 24 };
        threeLargest(arr);

    }
}