public class Leetcode_Accepted_one {
    // https://leetcode.com/problems/range-sum-query-mutable/
}


class NumArray {
    int tree[];
    int arr[];

    NumArray(int[] nums) { // Constructor should not have void keyword
        arr = nums;
        tree = new int[(arr.length) * 4]; // Line corrected, (arr.length) * 4
        buildST(arr, 0, 0, arr.length - 1);
    }

    void buildST(int arr[], int i, int s, int e) {
        if (s == e) {
            tree[i] = arr[s];
            return;
        }
        int mid = (s + e) / 2;
        buildST(arr, 2 * i + 1, s, mid);
        buildST(arr, 2 * i + 2, mid + 1, e);
        
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        System.out.println(tree[i] + " ");
    }

    public void update(int index, int val) {
        //NumArray(arr); // Incorrect call to constructor
        int dif = val - arr[index]; // Corrected variable name from idx to index
        arr[index] = val; // Corrected variable name from idx to index
        update_util(0, 0, arr.length - 1, index, dif);
    }

    void update_util(int i, int sti, int stj, int idx, int dif) {
        if (idx < sti || stj < idx) {
            return; // No Overlap no update 
        }

        /*For more clarity you can here also write if(ss==se) but No need*/
        tree[i] += dif;   // After sending what to do write here

        if (sti != stj) {  // Send to left, right part 
            int mid = (sti + stj) / 2;
            update_util(2 * i + 1, sti, mid, idx, dif);
            update_util(2 * i + 2, mid + 1, stj, idx, dif);
        }
    }

    public int sumRange(int left, int right) {
        //buildST(arr); // This line is not needed
        return getSum_util(0, 0, arr.length - 1, left, right);
    }

    int getSum_util(int i, int sti, int stj, int qi, int qj) {
        if (qj < sti || qi > stj) { // No Overlap
            return 0; // for Min or max Here we have to return Int.Max or Min accordingly
        } else if (sti >= qi && stj <= qj) { // Complete overlap
            return tree[i];
        } else { // Partial overlap, send to left and right part to get answer
            int mid = (sti + stj) / 2;
            int left = getSum_util(2 * i + 1, sti, mid, qi, qj);
            int right = getSum_util(2 * i + 2, mid + 1, stj, qi, qj);
            return left + right;
        }
    }
}

// Optimised segment tree 
class NumArray {
    int[] tree; 
    int n; 
    public NumArray(int[] nums) {
        this.tree = new int[4 * nums.length];
        n = nums.length; 
        buildTree(nums, 1, 0, n-1);  
    }

    private void buildTree(int[] nums, int i, int tl, int tr){
        if(tl == tr){
            tree[i] = nums[tl]; 
        }
        else{
            int tm = (tl + tr) / 2; 
            buildTree(nums, 2 * i, tl, tm);
            buildTree(nums, 2 * i + 1, tm+1, tr);
            tree[i] = tree[2*i] + tree[2*i+1]; 
        }
    }
    
    public void update(int index, int val) {
        updateTree(1, 0, n-1, index, val); 
    }

    private void updateTree(int i, int tl, int tr, int index, int val){
        if(tl == tr){
            tree[i] = val;
        }
        else{
            int tm = (tl + tr)/2; 
            if(index <= tm){
                updateTree(2*i, tl, tm, index, val);
            }
            else{
                updateTree(2*i+1, tm+1, tr, index, val); 
            }
            tree[i] = tree[2*i] + tree[2*i+1]; 
        }
    }
    
    public int sumRange(int left, int right) {
        return getSum(1, 0, n-1, left, right); 
    }

    private int getSum(int i, int tl, int tr, int l, int r){
        if(l > r) return 0;
        if(tl == l && tr == r) return tree[i]; 
        int tm = (tl + tr)/2; 
        return getSum(2*i, tl, tm, l, Math.min(r, tm)) + 
            getSum(2*i+1, tm+1, tr, Math.max(l, tm+1), r); 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

class NumArray {
    int[] tree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[2 * n];
        for (int i = 0; i < n; ++i) tree[n + i] = nums[i];
        for (int i = n - 1; i > 0; --i) tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    public void update(int index, int val) {
        for (tree[index += n] = val; index > 1; index /= 2)
            tree[index / 2] = tree[index] + tree[index ^ 1];
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (left += n, right += n; left <= right; left /= 2, right /= 2) {
            if ((left % 2) == 1) sum += tree[left++];
            if ((right % 2) == 0) sum += tree[right--];
        }
        return sum;
    }
}


 
// Now using Fenwick Tree

class NumArray {

    int[] nums;
    int[] BIT;

    public NumArray(int[] nums) {

        this.nums = nums;
        this.BIT = new int[nums.length + 1];

        for (int i = 1; i < BIT.length; i++) {
            init(i, nums[i - 1]);
        }
    }

    public void init(int i, int val) {
        // i++;
        while (i <= nums.length) {
            BIT[i] += val;
            i += (i & -i);
        }
    }

    public void update(int index, int val) {

        
        int diff = val - nums[index];
        nums[index] = val;
        init(index + 1, diff);

    }

    public int sumRange(int left, int right) {

        if (left == 0) {
            return getSum(right);
        } else {

            int high = getSum(right);
            int low = getSum(left);

            return ((high - low) + nums[left]);

        }

    }

    private int getSum(int limit) {

        limit++;
        int sum = 0;

        while (limit > 0) {
            sum = sum + BIT[limit];
            limit = limit - (limit & -limit);
        }

        return sum;
    }
}

 
class NumArray {

    int[] nums;
     int[] tree;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = buildFenwickTree(nums);
    }
    
    public int[] buildFenwickTree(int[] nums) {
        int[] tree = new int[nums.length + 1];

        System.arraycopy(nums, 0, tree, 1, nums.length);
        int p;

        for (int i = 1; i < tree.length; i++) {
            p = i + (i & -i);   // index to the parent total sum node
            //System.out.println("i: " + i + " p: " + p + " b: " + toBin(i) + " pb: " + toBin(p));
            if (p < tree.length)
                tree[p] += tree[i]; 
        }

        return tree;
    }   
    public void update(int index, int val) {
        // update parent values
        int valueToAdd = val - nums[index];
        nums[index] = val;
        add(index, valueToAdd);
    }
    
    public void add(int index, int val) {
        int i = index + 1;

        while (i < tree.length) {
            tree[i] += val;
            i += i & -i;
        }
    }

    public int getSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }

    public int sumRange(int left, int right) {
        return getSum(right + 1) - getSum(left);
    }

    public String toBin(int i) {
        return "0".repeat(Integer.numberOfLeadingZeros(i != 0 ? i : 1) - 26) + Integer.toBinaryString(i);
    }

    public void print(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */ 