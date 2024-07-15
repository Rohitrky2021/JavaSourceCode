//WAP on counting sort algorothm
public class countingsort {
    public static void countsort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest+1];
        //count at original array
        for(int i=0;i<arr.length;i++) {
            count[arr[i]]++;
        }
        //sorting
        //count at frequency array
        int j=0;
        for(int i=0;i<count.length;i++) {
            while(count[i]>0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    public static void printarray(int arr[]) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] ={5,4,1,3,2};
        countsort(arr);
        printarray(arr);
    }
}
