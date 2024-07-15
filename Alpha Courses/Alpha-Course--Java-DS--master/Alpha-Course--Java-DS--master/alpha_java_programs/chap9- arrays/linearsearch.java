//WAP to search an element in an array using linear search
public class linearsearch {
    public static int linear(int numbers[], int key) {
        for(int i=0;i<numbers.length;i++) {
            if(numbers[i] == key) { //tocheck if i is equal to key
                return i;
            }
        }
        return -1; //means that the key does not exist
    }
    public static void main(String[] args) {
        int numbers[] = {2,4,6,8,10,12,14,16};
        int key = 10;
        int index = linear(numbers, key);
        if(index == -1) {
            System.out.println("not found");
        } else {
            System.out.println("key is at index: " +index) ;
        }
        //System.out.println("key is at index");
    }
}
