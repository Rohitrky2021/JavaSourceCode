//WAP to find the largest number in an array
public class largestnumber {
    public static int largest(int numbers[]) {
        int largest = Integer.MIN_VALUE; //-infinity
        for(int i=0; i<numbers.length; i++) {
            if(largest < numbers[i]) {
                largest = numbers[i];
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int numbers[] = {1,2,6,3,5};
        System.out.println("Largest Value Is: " + largest(numbers));
    }
}
