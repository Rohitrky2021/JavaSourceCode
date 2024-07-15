// Java implementation of the approach--------->using \\SEGMENT TREE//
 //                                                    .============.

// class GFG{
    public class RangeOfRangeValue {
	
    // Procedure to build the segment tree
    static void buildTree(int tree[] , int arr[] ,
                        int index, int s, int e,
                        int A, int B)
    {
        
        // Reached the leaf node
        // of the segment tree
        if (s == e)
        {
            if (arr[s] >= A && arr[s] <= B)
                tree[index] = 1;
            else
                tree[index] = 0;
                
            return;
        }
    
        // Recursively call the buildTree
        // on both the nodes of the tree
        int mid = (s + e) / 2;
        buildTree(tree, arr, 2 * index,
                s, mid, A, B);
        buildTree(tree, arr, 2 * index + 1,
                mid + 1, e, A, B);
    
        tree[index] = tree[2 * index] +
                    tree[2 * index + 1];
    }
    
    // Query procedure to get the answer
    // for each query l and r are query range
    static int query(int tree[], int index, int s,
                    int e, int l, int r)
    {
        
        // Out of bound or no overlap
        if (r < s || l > e)
            return 0;
    
        // Complete overlap
        // Query range completely lies in
        // the segment tree node range
        if (s >= l && e <= r)
        {
            return tree[index];
        }
    
        // Partially overlap
        // Query range partially lies in
        // the segment tree node range
        int mid = (s + e) / 2;
        return (query(tree, 2 * index,
                    s, mid, l, r) +
                query(tree, 2 * index + 1,
                    mid + 1, e, l, r));
    }
    
    // Driver code
    public static void main (String []args)
    {
        int arr[] = { 7, 3, 9, 13, 5, 4 };
        int n = arr.length;
        int tree[] = new int [(4 * n + 1)];
    
        int L = 1, R = 5, A = 4, B = 7;
    
        buildTree(tree, arr, 1, 0, n - 1, A, B);
    
        System.out.print(query(tree, 1, 0, n - 1, L, R));
    }
    }
    
    // This code is contributed by chitranayal
    
}
