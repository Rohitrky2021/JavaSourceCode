public class MinConsidcutiveCardToPick {
    public int minimumCardPickup(int[] a) { // Minimum length of 2 Matching cards

        int[] count = new int[a.length];
       int tail = 0, ans = Integer.MAX_VALUE, distinctFruits = 0,max=0;

       for (int head = 0; head < a.length; head++) {
           int currentFruit = a[head];
           
        //    if (count[currentFruit] == 0) {
        //        distinctFruits++;
        //    }
           
             count[currentFruit]++;
             max =  Math.max(max, f[a[head]]);// Global max frew 
             

           // Check if the window needs adjustments to have at most two types of fruit
           while (max >= 2 && tail < a.length) {
            ans = Math.min(ans, head - tail + 1);
               int leftFruit = a[tail];
               count[leftFruit]--;
            //    if (count[leftFruit] == 0) {
            //        distinctFruits--;
            //    }
               tail++;
           }

        //    ans = Math.min(ans, head - tail + 1);
       }

       return ans==Integer.MAX_VALUE?0:ans;
   }
}
