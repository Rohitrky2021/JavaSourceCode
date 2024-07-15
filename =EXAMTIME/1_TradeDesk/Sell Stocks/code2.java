public class code2 {
    
}
ll ans=-(1e18);
   ll n=r.size();
   ll sum=0;
   for(ll i=0;i<n;i++){
       if(s[i]==1)
        sum +=r[i];
       if(s[i]==-1)
         sum -=r[i];
       ans=max(ans,sum);
   }
   vector<ll>sf;
   sum=0;
   for(ll i=0;i<n;i++){
       if(s[i]==1)
        sum +=r[i];
       if(s[i]==-1)
         sum -=r[i];
       sf.push_back(sum);
   }
   vector<ll>p;
   sum=0;
   for(ll i=n-1;i>=0;i--){
       if(s[i]==1)
        sum +=r[i];
       if(s[i]==-1)
         sum -=r[i];
       p.push_back(sum);
   }
   reverse(p.begin(),p.end());
   sum=0;
   for(ll i=k/2;i<k;i++){
       sum +=r[i];
   }
   if(k==n){
       ans=max(ans,sum);
       cout<<ans<<endl;
       return;
   }
   ans=max(ans,sum+p[k]);

   for(ll i=k;i<n;i++){
         sum -=r[i-k/2];
         sum +=r[i];
         if(i+1!=n){
          ans=max(ans,sf[i-k]+sum+p[i+1]);
             
         }
         else{
           ans=max(ans,sf[i-k]+sum);
           }
         
   }
   cout<<ans<<endl;