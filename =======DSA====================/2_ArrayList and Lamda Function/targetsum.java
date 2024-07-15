import java.util.*;
public class targetsum {
    public static void main(String args[]){
        int[] arr={1,2,3,4,5,67,};
    //   ;
        System.out.println(  combinationSum2(arr, 7));
    }
    

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int [] count = new int[51];
        for(int i : candidates) {
            count[i]++;
        }
        
        LinkedList<Integer> list = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        
        checkCombination(count, 1, target, list, result);
        return result;
    }
    
    /**
     * Check all possible combination for the given information set.
     * @param count Available numbers to fill the target.
     * @param i index of the array with which this level of recursion method will work on. If i = 0, this level will
     *          work on only candidate[0], i = 1 will work on only candidate[1] and so on....
     * @param target remaining target to fill. If this value is 0, then target is filled.
     * @param list current occurrences of number taken so far.
     * @param result contains all the combination so far found.
     */
    private static void checkCombination(int [] count, int i, int target, LinkedList<Integer> list, List<List<Integer>> result) {
        //if target reach to 0, then this is a result.
        if(target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        //if we reach out of the array, then nothing to check.
        else if(i > target)
            return;
        
        //we must check with candidate[i]. And take as much time as possible.
        int num = i, remaining = target;
        while (remaining >= num && count[num] > 0) {
            list.add(num);
            remaining -= num;
            count[num]--;
            
            //check with next index.
            checkCombination(count, i + 1, remaining, list, result);
        }
        
        //we have checked all possible combination with candidate[i]. we must remove them from the list.
        while (remaining < target) {
            remaining += num;
            list.removeLast();
            count[num]++;
        }
        
        //check without taking a single instance of candidate[i].
        checkCombination(count, i + 1, target, list, result);
    }
}