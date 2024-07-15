public class DutchSorting {
    public void dutchNationalFlag(int[] array) {
        int low = 0;
        int mid = 0;
        int high = array.length - 1;
    
        int firstValue = 0;  // Value for the first category
        int secondValue = 1; // Value for the second category
        int thirdValue = 2;  // Value for the third category
    
        while (mid <= high) {
            if (array[mid] == firstValue) {
                
                swap(array, low, mid);
                low++;
                mid++;
            } else if (array[mid] == secondValue) {
                mid++;
            } else if (array[mid] == thirdValue) {
                swap(array, mid, high);
                high--;
            }
        }
    }
    
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String args[]){
         
    }
    
}


