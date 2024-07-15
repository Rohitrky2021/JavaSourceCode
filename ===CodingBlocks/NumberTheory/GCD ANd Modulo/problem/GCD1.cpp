#include "bits/stdc++.h"
#define int long long 
using namespace std ;
const int mxN=1e5+1,mxA=1e6+1  ;
vector<int>p[mxA+1] ;
signed main(){
	for(int i=2;i<mxA;i++){
		if(!p[i].empty())
			continue  ;
		for(int j=i;j<mxA;j+=i)
			p[j].push_back(i) ;
	}
	int n,ans=0,m ;
	cin >> n >>m ;
	vector<int>a(n),b(m) ;
 	for(int &x:a)
 		cin >> x  ;
 	for(int &x:b)
 		cin >> x  ;
 	auto get=[&](vector<int>&e){
 		map<int,int>c  ;
 		for(int x:e){
	 		int m = p[x].size() ;
	 		for(int j=0;j<(1<<m);j++){
	 			int k=0,j1=j,pd=1  ;
	 			while(j1){
	 				if(j1&1)
	 					pd*=p[x][k] ;
	 				j1/=2 ;k++ ;
	 			}
	 			c[pd]++ ;
	 		}
	 	}
	 	return c ;
 	}  ;
 	map<int,int>ca=get(a),cb=get(b) ;
 	for(int i=2;i<mxA;i++)
 		ans+=ca[i]*cb[i]*(p[i].size()&1?1:-1) ;
 	cout <<ans << '\n' ;
}