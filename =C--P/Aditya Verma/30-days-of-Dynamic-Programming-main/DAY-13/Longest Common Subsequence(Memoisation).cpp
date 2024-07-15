#include <bits/stdc++.h>
#define lli long long int
#define endl "\n"
#define MAX 10005
#define MOD 1000000007
using namespace std;

int dp[MAX][MAX];
int LCS(string s1, string s2, int n, int m){

	if((n==0) || (m==0)) return 0;
	
	if(dp[n][m] == -1)
	{
		if(s1[n-1] == s2[m-1]) 
			dp[n][m] = 1 + LCS(s1,s2,n-1,m-1);
		else 
			dp[n][m] = max(LCS(s1,s2,n, m-1), LCS(s1,s2,n-1,m));	
	}
	
	return dp[n][m];
}

int main()
{
	memset(dp, -1, sizeof(dp));
	string s1 = "ABCDE";
	string s2 = "AKLDFGE";
	cout<<LCS(s1, s2, s1.length(), s2.length());
	return 0;
}