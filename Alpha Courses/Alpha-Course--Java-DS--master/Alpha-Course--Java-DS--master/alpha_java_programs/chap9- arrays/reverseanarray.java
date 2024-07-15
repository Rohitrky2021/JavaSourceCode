//WAP to reverse an array in java
public class reverseanarray {
    public static void reverse(int numbers[]) {
        int first = 0, last = numbers.length-1;
        while(first<last) {
            //swap values
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;
            //the above 3 lines is the classical code to reverse elements 
            //in an array

            first++;
            last--;
        }
    }
    public static void main(String[] args) {
        int numbers[] = {2,4,6,8,10};
        reverse(numbers);
        //print array
        for(int i=0;i<numbers.length;i++) {
            System.out.println(numbers[i] + " ");
        }
        System.out.println();
    }
}
