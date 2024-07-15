import java.util.*;

// https://www.interviewbit.com/problems/ways-to-form-max-heap/hints/

/**
 * So final equation will be as follows :
 * 
 ** ==>  (n-1)^C>L * getNumberOfMaxHeaps(L) * getNumberOfMaxHeaps(R)
 * 
 */


// M 1  ---> Official Solution 
public class  WaysToFormMaxHeap {
    
    long[] dp;  	/* dp[i] = number of max heaps for i distinct integers */
    long[][] nck;	/* nck[i][j] = i choose j if i>=j else 0 */
    int[] log2;		/* log2[i] = int(log base 2 of i) */
    
    final long MOD = 1000000007;
    
    public long choose(int n,int k)
    {
        if(k>n)
            return 0;
	if(n<=1)
	    return 1;
	if(k==0)
	    return 1;

        if(nck[n][k]!=-1)
            return nck[n][k];
        long answer = choose(n-1,k-1) + choose(n-1,k);
        answer%=MOD;
        nck[n][k] = answer;
        return answer;
    }
    
    public int getL(int n)
    {
        if(n==1)
            return 0;
            
        int h = log2[n];
        int p = n - ((1<<(h)) - 1);
        int m = (1<<h);
        if(p>=(m/2))
            return (1<<(h)) - 1;
        else
            return (1<<(h)) - 1 - ((m/2) - p);
    }
    
    public int solve(int n)
    {
        dp = new long[n+1];
        for(int i=0;i<=n;i++)
            dp[i]=-1;
            
        nck = new long[n+1][n+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=n;j++)
                nck[i][j] = -1;
                
        log2 = new int[n+1];
        int currLogAnswer = -1;
        int currPower2 = 1;
        for(int i=1;i<=n;i++)
        {
	    if(currPower2==i)
            {
                currLogAnswer++;
                currPower2*=2;
            }
            log2[i] = currLogAnswer;
        }
        
        return (int)getNumberOfMaxHeaps(n);
    }
    
    public long getNumberOfMaxHeaps(int n)
    {
        if(n<=1)
            return 1;
            
        if(dp[n]!=-1)
            return dp[n];

        int L = getL(n);
        long ans = (choose(n-1,L)*getNumberOfMaxHeaps(L))%MOD*(getNumberOfMaxHeaps(n-1-L));
        ans%=MOD;
        dp[n] = ans;
        return ans;
    }
}

// M--2 
public class WaysToFormMaxHeap2 {
    final static long MOD = 1000000007;
    final static int MAXN = 101;

    static class Pair {
        int left, right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static long[] table = new long[MAXN];

    static void initTable() {
        table[0] = 1;
        for (int i = 1; i < MAXN; ++i)
            table[i] = (table[i - 1] << 1) % MOD;
    }

    static int height(int size) {
        int h = 0;
        while (table[h] <= size)
            h++;
        return h;
    }

    static long powVar(long base, long p) {
        if (p == 0)
            return 1;
        long res = powVar((base * base) % MOD, p / 2);
        if (p % 2 == 1)
            res = (res * base) % MOD;
        return res;
    }

    static long C(int n, int k) {
        if (k > n / 2)
            k = n - k;

        long res = 1;
        for (int i = 0; i < k; ++i, --n)
            res = (res * n) % MOD;
        for (int i = 1; i <= k; ++i)
            res = (res * powVar(i, MOD - 2)) % MOD;

        return res;
    }

    static Pair subtrees(int n) {
        if (n < 2)
            return new Pair(0, 0);
        int h = height(n);
        int lastRow = n - (int) (table[h - 1] - 1);
        int maxLRow = (int) table[h - 1];
        int l = (int) (table[h - 2] - 1 + Math.min(maxLRow / 2, lastRow));
        int r = n - l - 1;
        return new Pair(l, r);
    }

    static long zolve(int n) {
        if (n < 3)
            return 1;
        Pair childz = subtrees(n);
        int l = childz.left;
        int r = childz.right;
        return (((C(n - 1, l) * zolve(l)) % MOD) * zolve(r)) % MOD;
    }

    public int solve(int A) {
        initTable();
        return (int) zolve(A);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(5)); // Example usage
    }
}
