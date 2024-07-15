import java.util.*;
public class segmentTree {


    // ALL in O(Logn)---- for both quire and update
   public static int[] tree;
   static int n;
   public static void inti(int n){
    tree=new int[4*n];
}

public static void buidtree(int i,int si,int sj,int arr[]){
    if(si==sj){
        tree[i]=arr[si];
        return;
    }
    int mid=(si+sj)/2;
    buidtree(2*i+1, si, mid, arr);
    buidtree(2*i+2, mid+1, sj, arr);
    tree[i]=Math.max(tree[2*i+1], tree[2*i+2]);

}

    
static class SegmentTree {

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[n * 2];

        // build the segment tree bottom-up
        for (int i = n; i < n * 2; i++) {
            tree[i] = arr[i - n];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public int rangeSum(int startIndex, int endIndex) {
        int sum = 0;
        startIndex += n;
        endIndex += n;
        while (startIndex <= endIndex) {
            if (startIndex % 2 == 1) {
                sum += tree[startIndex];
                startIndex++;
            }
            if (endIndex % 2 == 0) {
                sum += tree[endIndex];
                endIndex--;
            }
            startIndex /= 2;
            endIndex /= 2;
        }
        return sum;
    }
    public void update(int index, int value) {
        index += n;
        tree[index] = value;
        while (index > 0) {
            int parent = index / 2;
            tree[parent] = tree[parent * 2] + tree[parent * 2 + 1];
            index = parent;
        }
    }

    // public int  Maxoftree(int arr[]){
    //     return 
    // }
}

// *****************RANGE SUM *********************************//

public static void main(String args[]){
int[] arr = {1, 2, 3, 4, 5};
SegmentTree segmentTree = new SegmentTree(arr);
int startIndex = 1;
int endIndex = 3;
int rangeSum = segmentTree.rangeSum(startIndex, endIndex);

System.out.println("Range sum: " + rangeSum);




// **************UPDATE***********//


// int[] arr = {6,8,-1,2,17,1,3,2,4};
// SegmentTree segmentTree = new SegmentTree(arr);
// int indexToUpdate = 3;
// int newValue = 10;
// segmentTree.update(indexToUpdate, newValue);
// // System.out.println("Range sum: " + rangeSum);
// int n=arr.length;
// // segmentTree.inti(n);
// inti(n);
// buidtree(0, 0, n-1, arr);

// // int startIndex = 1;
// // int endIndex = 3;
// // int rangeSum = segmentTree.rangeSum(startIndex, endIndex);
// for (int i = 0; i < tree.length; i++) {
    
//     System.out.print(tree[i]+" ");
// }
// init(n);












}
}