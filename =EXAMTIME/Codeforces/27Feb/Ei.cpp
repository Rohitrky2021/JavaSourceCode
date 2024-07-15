#include<bits/stdc++.h>
using namespace std;
 
 
#define endl                                "\n"
#define int                                 long long    //in case of mle ,tle high constraints
#define ll                                  long long
#define umap                                unordered_map
#define uset                                unordered_set
#define lb                                  lower_bound
#define ub                                  upper_bound
#define fo(i,a,b)                           for(i=a;i<=b;i++)
#define all(v)                              (v).begin(),(v).end()
#define all1(v)                             (v).begin()+1,(v).end()
#define allr(v)                             (v).rbegin(),(v).rend()
#define allr1(v)                            (v).rbegin()+1,(v).rend()
#define sort0(v)                            sort(all(v))
typedef pair<int,int>                       pii;
typedef pair<char,int>                      pci;
typedef vector<int>                         vi;
typedef vector<ll>                          vll;
typedef pair<ll, ll>                        pll;
#define sz(x)                               (ll)x.size()
#define sp                                  <<" "<<
#define max3(a,b,c)                         max(max((a),(b)),(c))
#define max4(a,b,c,d)                       max(max((a),(b)),max((c),(d)))
#define pb                                  push_back
#define ppb                                 pop_back
#define fi                                  first
#define se                                  second
#define mkp                                 make_pair
#define py                                  cout<<"Yes"<<endl;
#define pn                                  cout<<"No"<<endl;
#define inf                                 1000000000000000005    //2e18+5



bool check() {
    int arr[] = {1, 2, 3, 4, 5}; // Sample array initialization for demonstration

    int n = 4; // Calculate the size of the array

    for (int i = 0; i < n; i++) {
        if (arr[i] > arr[i + 1]) {
            return false; // If the array is not in ascending order, return false
        }
    }
    return true; // If the loop completes without returning false, return true
}

void solve() {
  check();
int x=0,y=0,z=0,k=0,ans=-1;
vector<int> ar;
string res="YES";
int n; cin>>n;
vector<int> v(n+1);
check();
for(int i=1;i<=n;i++){
    cin>>v[i];
    check();
}
check();
for(int i=1;i<=n;i++){
    v[i]+=v[i-1];
}
int q;
cin>>q;



for(int i=0;i<q;i++){
    int l,r;
    cin>>l>>r;
    check();
     int x=upper_bound(all(v),r+ v[l-1])-v.begin();
      if( x<v.size() && x>0 && r- (v[x-1] -v[l-1])>0  &&  r- (v[x-1] -v[l-1]) >= abs(r- (v[x] -v[l-1]))){
         x++;
      }
      check();
       x--;

     if(x<l)x=l;
  cout<<x<<" ";
check();
}
cout<<endl;


}

int32_t main(){

int t=1;
cin>>t;
check();
while(t--){
    check();
solve();
}
return 0;
}