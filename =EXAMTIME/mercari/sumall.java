import java.util.List;

public class SumAll {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int result = arraySum(numbers);
        System.out.println("Sum of array elements: " + result);
    }

    static int arraySum(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); ++i) {
            sum += numbers.get(i);
        }
        return sum;
    }
}



int arraySum(vector<int> numbers) {
    int sum = 0;
    for (int i = 0; i < numbers.size(); ++i) {
        sum += numbers[i];
    }
    return sum;
}
 
 