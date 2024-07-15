public class code1 {
    
}


int n=sc.nextInt(),k=sc.nextInt(),i,c=0,d=n-1;
            int rates[]=new int[n];
            int strat[]=new int[n];
            for(i=0;i<n;i++) rates[i]=sc.nextInt();
            for(i=0;i<n;i++) strat[i]=sc.nextInt();
            int pref[]=new int[n];
            int suff[]=new int[n];
            pref[0]=rates[0]*strat[0];
            for(i=1;i<n;i++) pref[i]=pref[i-1]+strat[i]*rates[i];
            suff[n-1]=rates[n-1]*strat[n-1];
            for(i=n-2;i>=0;i--) suff[i]=suff[i+1]+strat[i]*rates[i];
            int ans=Integer.MIN_VALUE,sum=0;
            for(i=k/2;i<k;i++) sum+=rates[i];
            ans=Math.max(ans,sum+suff[k]);
            //System.out.println(sum);
            for(i=k;i<n-1;i++){
                sum=sum-rates[i-k/2];
                sum=sum+rates[i];
                ans=Math.max(ans,sum+pref[c]+suff[d]);
                c++;
                d--;
                //System.out.println(sum+" "+rates[i]+" "+ans);
            }
            sum=sum-rates[n-1-k/2]+rates[n-1];
            ans=Math.max(ans,sum+pref[c]);
            System.out.println(ans);