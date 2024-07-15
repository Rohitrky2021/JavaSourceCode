public class code {
    
}
void solve(vector<ll> a,ll l ,ll r){
   set<pair<ll,ll>>s;
   map<ll,ll>m;
   ll i=0;
   ll ans=INT_MAX;
   for(auto x:a){
       
       if(x<l || x>r){
           i++;
           continue;
       }
       else{
           if(m.find(x)==m.end()){
               m[x]=i;
               s.insert({i,x});
           }
           else{
               s.erase({m[x],x});
               s.insert({i,x});
               m[x]=i;
           }
       }
       //cout<<i<<" "<<m.size()<<endl;
       if(m.size()==r-l+1){
           auto it=s.begin();
          
           ans=min(ans,i-(*s.begin()).first+1);
       }
       i++;
   }
   cout<<(ans==INT_MAX?-1:ans)<<endl;
}

Tradedesk ✅

