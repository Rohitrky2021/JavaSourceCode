public class changeArrbt {
    public static void main(String args[]) {
        int arr[] = new int[5];
        changearr(arr, 0, 1);
        // System.out.println(arr);
        print(arr);
    }

    public static void changearr(int xyz[], int i, int val) {

        // for ( i= 0; i< xyz.length; i++) {
        // xyz[i]=val;

        // val++;
        // }
        // System.out.println(xyz[3]);
        if (i == xyz.length) {
            print(xyz);
            return;
        }
        xyz[i] = val;
        changearr(xyz, i + 1, val + 1);
        xyz[i] -= 2;

    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
