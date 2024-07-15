#define ll long long
#define MOD 1000000007

int n, m;
ll dp[300][100100];
int bit[300]={0};

ll dfs(int x, int par, int mask,vector<int>& v){
	if(dp[mask][x] != -1)return dp[mask][x];
	ll ret = 0;
	for(int i=1; i<=m; i++){
		int flag = 1;
		ll p = 1;
		for(int j=0; j < v[x].size(); j++){
			if(v[x][j] == par)continue;
			p = (p*dfs(v[x][j], x, mask & bit[i]))%MOD;
			flag = 0;
		}
		if(flag){
			if((mask&bit[i]) == 0)ret++;
		}
		else{
			ret = (ret+p)%MOD;
		}
	}
	return dp[mask][x]=ret;
}
int helper(int A,int B,vector<int>& C){
    int arr[8] = {2, 3, 5, 7, 11, 13, 17, 19};
	for(int i=1; i<=m; i++){
		for(int j=0; j<8; j++)
			if(i%arr[j] == 0)
				bit[i]|=(1<<j);
	}

	cout<<dfs(1, -1, 255,)<<endl;
}