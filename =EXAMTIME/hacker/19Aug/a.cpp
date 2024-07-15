long Count_sol (int N, vector<int> A, vector<int> B) {
   // Write your code here
   vector<long>dp(MAXN,0);
   unordered_map<int, int>f;
   unordered_map<int, int>g;
   for(int i=0;i<N;i++)
   {
    f[A[i]]++;
    g[B[i]]++;
   }
   long ans=0;
   for(int i=100000;i>=2;--i)
   {
    int c=0;
    int d=0;
    int s=0;
    for(int j=i;j<=100000;j+=i)
    {
        c+=f[j];
        d+=g[j];
        s+=dp[j];
    }
    long pw=(long)c*d;
    pw=pw-s;
    ans+=pw;
    dp[i]=pw;
   }
   return ans;
}

Count the Pairs ✅


#include <vector>
#include <queue>
using namespace std;

int solve(vector<int> ropes) {
    priority_queue<int> pq(ropes.begin(), ropes.end());
    int ans = 0;
    while (pq.size() > 1) {
        int rope1 = pq.top();
        pq.pop();
        int rope2 = pq.top();
        pq.pop();
        if (rope1 < 2 || rope2 < 2) {
            break;
        }
        ans += (rope1 - 1) * (rope2 - 1);
    }
    return ans;
}

Ropes Pair Length ✅


int Arr_Diff (vector<int> arr) {
   // Write your code here
   int n=arr.size();
   int maxi=INT_MIN;
   int mini=INT_MAX;
   for(int i=0;i<n;i++)
   {
    if(arr[i]%2!=0)
    arr[i]=2*arr[i];
    maxi=max(maxi,arr[i]);
    mini=min(mini,arr[i]);
   }
   priority_queue<int>pq;
   for(int i=0;i<n;i++)
   {
    pq.push(arr[i]);
   }
   int min_dev=maxi-mini;
   int top=0;
   while(pq.top()%2==0)
   {
    top=pq.top();
    pq.pop();
    min_dev=min(min_dev,top-mini);
    mini=min(mini,top/2);
    pq.push(top/2);
   }
   top=pq.top();
   min_dev=min(min_dev,top-mini);
   return min_dev;
}

Array Difference ✅


int solution (vector<int> chocolates, int M, int N) {
   // Find the maximum number of chocolates that can be selected.
   const int u=100005;
   long long int l[u];
   long long int ans=0;
   memset(l,-1,sizeof(l));
   l[0]=0;
   long long int s=0;
   for(int i=0;i<N;i++)
   {
    s+=chocolates[i];
    int tm=s%M;
    if(-1==l[tm])
    l[tm]=s;
    else
     ans=max(ans,s-l[tm]);
   }
   return static_cast<int>(ans/M);
}

Chocolate Distribution ✅


int solve(vector<vector<int>>& items,int i,int k,vector<vector<int>>& dp){
    int n=items.size();
    if(i>=n)
        return 0;
    if(dp[i][k]!=-1)
        return dp[i][k];
    int ans=0;
    int take=0,notTake=0;
    int nextIndex=i;
    int currItem=item[i][0];
    for(;nextIndex<n;nextIndex++){
        if(items[nextIndex]!=currItem)
            break;
    }
    if(items[i][1]<=k)
        take=items[i][2]+solve(items,nextIndex,k-items[i][1],dp);
    notTake=solve(items,i+1,k,dp);
    return dp[i][k]=max(take,notTake);
}
int modified_knapsack(vector<vector<int>>& items,int k){
    sort(items.begin(),items.end());
    vector<vector<int>> dp(items.size()+1,vector<int>(k+1,-1));
    solve(items,0,k,dp);
}

modified knapsack   ✅ 


#include <vector>
#include <tuple>
#include <algorithm>

using namespace std;

int64_t findMax(vector<vector<int>>& items, int k) {
    int n = items.size() - 1;
    vector<vector<int64_t>> dp(n + 1, vector<int64_t>(k + 1, 0));
    vector<int> ult(n + 5, -1);

    // Sort the items based on their type (tp) in ascending order
    sort(items.begin() + 1, items.end());

    for (int i = 1; i <= n; i++) {
        int tp = items[i][0];
        int wt = items[i][1];
        int val = items[i][2];
        int lsttp = ult[tp];
        if (-1 == lsttp) lsttp = i - 1;
        for (int ow = 0; ow <= k; ow++) {
            dp[i][ow] = max(dp[i][ow], dp[i - 1][ow]);
            if (wt + ow <= k) {
                dp[i][wt + ow] = max({ dp[i][wt + ow], dp[lsttp][ow] + val, dp[i - 1][wt + ow] });
            }
        }
        
        if (-1 == ult[tp]) ult[tp] = i - 1;
    }

    int64_t res = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= k; j++) {
            res = max(res, dp[i][j]);
        }
    }

    return res;
}

int main() {
    int n;
    cin >> n;
    vector<vector<int>> items(n + 1, vector<int>(3));
    for (int i = 1; i <= n; i++) {
        cin >> items[i][0] >> items[i][1] >> items[i][2];
    }

    int k;
    cin >> k;

    int64_t result = findMax(items, k);
    cout << result << endl;

    return 0;
}

Modified knapsack ✅


#include <bits/stdc++.h>
using namespace std;

const int MOD = 1000000007;

long long countMaxXOR(int N, int K) {
    vector<vector<long long>> dp(N + 1, vector<long long>((1 << K), 0));
    dp[1][0] = 1;

    for (int i = 2; i <= N; i++) {
        for (int j = 0; j < (1 << K); j++) {
            for (int k = 0; k < (1 << K); k++) {
                if ((j ^ k) > j) {
                    dp[i][j ^ k] = (dp[i][j ^ k] + dp[i - 1][j]) % MOD;
                }
            }
        }
    }

    long long total_count = 0;
    for (int j = 0; j < (1 << K); j++) {
        total_count = (total_count + dp[N][j]) % MOD;
    }

    return total_count;
}

Array Construction ✅