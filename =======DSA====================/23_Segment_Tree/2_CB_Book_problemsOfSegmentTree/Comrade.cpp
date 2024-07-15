// @csalgo

// Problem Name: Comrades
// Problem Difficulty: 
// Problem Constraints: 1 <= N <= 100000
// 1 <= Q <= 100000
// 1 <= Type <= 3
// 1 <= S <= N
// A soldier cannot be his own superior.
// Problem Description:
// The human army has proved itself against the mighty aliens by winning the Great War.
// But even in times of peace, the army should remain alert and disciplined.

// The army has ***N*** soldiers. The soldiers are numbered from 1 to N. The army has a superiority hierarchy. *Every soldier has one immediate superior*. The superior of a superior of a soldier is also a superior to that soldier. So, a soldier may have one or more superiors but only one immediate superior.

// As a exercise to determine the efficiency of the army, the following drill has been designed.

// You are given a list of orders. Each order is of the form "Type ID"
// where Type is either 1,2 or 3 and ID is a number S (1<=S<=N) that denotes a soldier.

// There are three types of orders:<br>
// Type 1: 
// All the soldiers who have S as one of their superior will wake up.

// Type 2:
// All the soldiers who have S as one of their superior will go to sleep.

// Type 3:
// Count and output the number of soldiers who are awake and have S as one of their superior.

// NOTE: Among all soldiers there is one soldier who does not have any superior. He is the commander of the whole army.

// Problem credits :- <a href="https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/comrades-iii/"> Hackerearth </a>.

// Input Format: The first line contains N, the number of soldiers. The next line contains N space separated integers. The ith integer represents the immediate superior of the ith soldier.
// The immediate superior of the commander of the army will be '0'.

// The third line contains Q, the number of orders.
// Each of the next Q lines contain two integers, the type of order and S.
// Sample Input: 3
// 2 0 1
// 3
// 3 1
// 2 1
// 3 1
// Output Format: For each Type-3 order, output the number of soldiers who are awake and have the given soldier as their superior.
// Sample Output: 1
// 0



// =====Solution=====
/*input
3
2 0 1
3
3 1
2 1
3 1
*/
#include <bits/stdc++.h>
#include<stdio.h>
using namespace std;
#define F(i,a,b) for(int i = a; i <= b; i++)
#define RF(i,a,b) for(int i = a; i >= b; i--)
#define pii pair<int,int>
#define PI 3.14159265358979323846264338327950288
#define ll long long
#define ff first
#define ss second
#define pb(x) push_back(x)
#define mp(x,y) make_pair(x,y)
#define debug(x) cout << #x << " = " << x << endl
#define INF 1000000009
#define mod 1000000007
#define S(x) scanf("%d",&x)
#define S2(x,y) scanf("%d%d",&x,&y)
#define P(x) printf("%d\n",x)
#define all(v) v.begin(),v.end()
#define MX 200005
vector <ll> g[MX];
ll intime[MX],outtime[MX];
ll parent[MX],n,root; 
ll timer;
bool vis[MX];
ll tree[4*MX],lazy[4*MX];
void dfs(ll node)
{
	vis[node] = 1;
	intime[node] = ++timer;
	ll sz = g[node].size();
	F(i,0,sz-1)
	{
		ll child = g[node][i];
		if(!vis[child])
			dfs(child);
	}
	outtime[node] = timer;
}
void build(ll low,ll high,ll index)
{
	if(low > high)
		return;
	if(low == high)
	{
		tree[index] = 1; // initial all values are 1 for all nodes that is all are awake
		lazy[index] = 0; // means no update pending at this node
		return;
	}
	ll mid = (low + high)/2;
	build(low,mid,2*index);
	build(mid+1,high,2*index+1);
	tree[index] = tree[2*index] + tree[2*index+1];
}
void update_range(ll low,ll high,ll l,ll r,ll index,ll type)
{
	if(low > high)
		return;
	if(lazy[index] > 0) //  pending update
	{
		if(lazy[index] == 1) // wake up all
			tree[index] = high - low + 1;
		else // sleep all
			tree[index] = 0;
		if(low != high) // if left and right child exists
		{
			if(low != high)
				lazy[2*index+1] = lazy[2*index] = lazy[index]; // identify type of update
		}
		lazy[index] = 0; // no pending update at this index
	}
	if(low > r || high < l) // out of bounds so return
		return;
	if(low >= l && high <= r) // fully in range
	{
		if(type == 1) // update this node not its children
			tree[index] = high - low + 1;
		else
			tree[index] = 0;
		if(low != high) // pass the update to children using lazy
			lazy[2*index+1] = lazy[2*index] = type;
		return;
	}
	ll mid = (low+high)/2;
	update_range(low,mid,l,r,2*index,type);
	update_range(mid+1,high,l,r,2*index+1,type);
	tree[index] = tree[2*index] + tree[2*index+1];
}
ll query(ll low,ll high,ll l,ll r,ll index)
{
	if(low > high)
		return 0;
	if(lazy[index] > 0) //  pending update
	{
		if(lazy[index] == 1) // wake up all
			tree[index] = high - low + 1;
		else // sleep all
			tree[index] = 0;
		if(low != high) // if left and right child exists
		{
			if(low != high)
				lazy[2*index+1] = lazy[2*index] = lazy[index]; // identify type of update
		}
		lazy[index] = 0; // no pending update at this index
	}
	if(low > r || high < l) // out of bounds so return
		return 0;
	if(low >= l && high <= r)
		return tree[index];
	ll mid = (low + high)/2;
	ll a = query(low,mid,l,r,2*index);
	ll b = query(mid+1,high,l,r,2*index+1);
	return (a+b);
}
int main() 
{
	std::ios::sync_with_stdio(false);
	cin>>n;
	F(i,1,n)
	{
		cin>>parent[i];
		if(parent[i]!=0)
			g[parent[i]].pb(i);
		if(parent[i] == 0)
			root = i;
	}
	dfs(root);
	build(1,n,1);
	ll q;
	cin>>q;
	while(q--)
	{
		ll type,node;
		cin>>type>>node;
		ll l = intime[node]+1;
		ll r = outtime[node];
		if(type <= 2)
			update_range(1,n,l,r,1,type);
		else
		{
			ll ans = query(1,n,l,r,1);
			cout<<ans<<endl;
		}
	}
	return 0;
}

// @csalgo Telegram