package T01_Arrays;

class Arr01_ThreeLargest {

    public static void threeLargest(int arr[]) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (first < arr[i]) {
                int temp = first;
                first = arr[i];
                int temp2 = second;
                second = temp;
                third = temp2;
            } else if (second < arr[i] && first > arr[i]) {
                int temp3 = second;
                second = arr[i];
                third = temp3;
            } else if (third < arr[i] && second > arr[i]) {
                third = arr[i];
            }
        }
        System.out.println(first + " " + second + " " + third);
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