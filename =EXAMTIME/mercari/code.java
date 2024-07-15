public class code {
    Integer[] arr = nums.toArray(new Integer[nums.size()]);

 
    

    
    // Now, you can treat 'arr' as an array and write your logic
    int n = arr.length;
    
    // Your logic goes here
   
    
    // Create a List to store the result
    List<Integer> result = new ArrayList<>();
    
    // Add elements to the result list
    for (int num : arr) {
        result.add(num);
    }
    
    return result; // Return the result as a List 
}
 
int arraySum(vector<int> numbers) {
    int sum = 0;
    for (int i = 0; i < numbers.size(); ++i) {
        sum += numbers[i];
    }
    return sum;
}
 
 

vector<int> reverseArray(vector<int> arr) {
    int start = 0;
    int end = arr.size() - 1;
    while (start < end) {
        // Swap elements at start and end indices
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        // Move indices towards the center
        start++;
        end--;
    }
    return arr;
}
// ercari QS 2
//Reverse a list edited 10:52 PM




int fourthBit(int number) { int binary[32];
    int index = 0;
    while (number > 0) { binary[index] = number % 2;
        number = number / 2; index++;
    }
    return (index >= 4) ? binary[3] : 0;}
// ercari QS 3
//4th Bit edited 10:52 PM




string dnaComplement(string s) {
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        start++;
        end--;
    }
    for (int i = 0; i < s.length(); ++i) {
        switch (s[i]) {
            case 'A':
                s[i] = 'T';
                break;
            case 'T':
                s[i] = 'A';
                break;
            case 'C':
                s[i] = 'G';
                break;
            case 'G':
                s[i] = 'C';
                break;
            default:
                break;
        }
    }
    return s;
}
// ercari QS 4
//Comp. a DNA Strand edited 10:52 PM



int maxXor(int lo, int hi, int k) {
    int max_XOR = 0;
    for (int a = lo; a <= hi; ++a) {
        for (int b = a + 1; b <= hi; ++b) {
            int current_XOR = a ^ b;
            if (current_XOR > max_XOR && current_XOR <= k) {
                max_XOR = current_XOR;
            }
        }
    }
    return max_XOR;
}
// ercari QS 5
//Bit Logic
 