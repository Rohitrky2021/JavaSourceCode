package string;

public class largest{
    public static void main(String[] args) {
        String fruits[] = {"apple","ananas","banana"};
        String largest = largest_string(fruits);
        System.out.println(largest);

    }

    private static String largest_string(String[] fruits) {
        String largest = fruits[0];
        for(int i=0;i<fruits.length;i++){
            if(largest.compareTo(fruits[i])<=0){
                largest = fruits[i];
            }
        }
        return largest;
    }
}