public class A {
    public int differenceOfSums(int a, int x) {
        int a1=0,a2=0;
        for (int i = 1; i <= a; i++) {
            if(i%x!=0)a1+=i;
        }
        isSorted(new int[]{1,2,3});
        for (int i = 1; i <= a; i++) {
            if(i%x==0)a2+=i;
        }

        return a2-a1;
        
    }
        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
