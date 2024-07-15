// https://leetcode.com/problems/number-of-beautiful-integers-in-the-range/description/?envType=list&envId=r8bvg0x3


import java.util.ArrayList;
import java.util.List;

class Solution {
    int k;
    int[][][][][][] dp = new int[11][11][2][25][11][2];

    int find(int len, boolean tight, int sum, int odd, boolean isZero, int actualLength, List<Integer> digits) {
        if (len == digits.size()) {
            if ((actualLength - odd == odd) && (sum == 0) && !isZero) {
                return 1;
            }
            return 0;
        }
        if (dp[len][actualLength][tight ? 1 : 0][sum][odd][isZero ? 1 : 0] != -1) {
            return dp[len][actualLength][tight ? 1 : 0][sum][odd][isZero ? 1 : 0];
        }

        int limit = 9, res = 0;
        if (tight) {
            limit = digits.get(len);
        }

        for (int dig = 0; dig <= limit; dig++) {
         res += find(len + 1, (tight && (dig == limit)), (10 * sum + dig) % k, odd + (dig % 2), (isZero && (dig == 0)), (isZero && (dig == 0)) ? 0 : actualLength + 1, digits);
        }

        return (dp[len][actualLength][tight ? 1 : 0][sum][odd][isZero ? 1 : 0] = res);
    }

    int go(int x) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 25; l++) {
                        for (int m = 0; m < 11; m++) {
                            for (int n = 0; n < 2; n++) {
                                dp[i][j][k][l][m][n] = -1;
                            }
                        }
                    }
                }
            }
        }
        
        List<Integer> digits = new ArrayList<>();
        int m = x;
        while (m > 0) {
            digits.add(m % 10);
            m /= 10;
        }
        Collections.reverse(digits);
        return find(0, true, 0, 0, true, 0, digits);
    }

    int numberOfBeautifulIntegers(int low, int high, int K) {
        k = K;
        return go(high) - go(low - 1);
    }
}


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>




   
class Solution {
    
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        return count(0,4,4,k,low,high);
        
    }
    
     public int count(int val, int odd, int even, int k,int low, int high){
        
        if(val>high)return 0;
        int ans=0;
        if(val%k==0 && val>=low && val<=high && odd==even)ans=1;
        if(even==0 && odd ==0)return ans;
        if(even>0){
             ans+= count(val*10+2,odd, even-1,k,low,high) 
                   + count(val*10+4,odd, even-1,k,low,high)
                   + count(val*10+6,odd, even-1,k,low,high)
                   + count(val*10+8,odd, even-1,k,low,high) ;
            if(val>0)ans+= count(val*10+0,odd, even-1,k,low,high);
        }
         if(odd>0){
            ans+= count(val*10+1,odd-1, even,k,low,high) 
                 +count(val*10+3,odd-1, even,k,low,high)
                 +count(val*10+5,odd-1, even,k,low,high)
                 +count(val*10+7,odd-1, even,k,low,high)
                 +count(val*10+9,odd-1, even,k,low,high);
         }
         return ans;
     }

}


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>


class Solution {
    String s;
    int k;
    Integer[][][][][] dp;
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        this.k = k;
        s = Integer.toString(low-1);
        dp = new Integer[s.length()][2][2][21][21];
        int l = f(0,true,true, 0, 0);
        
        s = Integer.toString(high);

        dp = new Integer[s.length()][2][2][21][21];
        int h = f(0,true,true, 0, 0);
        return h-l;
    }
    
    public int f(int i, boolean bound,boolean isZero, int cnt, int rem){
        
        if(i == s.length()){
            if(cnt == 0 && rem == 0){
                return 1;
            } 
            return 0;   
        }
        
        if(dp[i][bound ? 1 : 0][isZero ? 1 : 0][cnt+10][rem] != null) return dp[i][bound ? 1 : 0][isZero ? 1 : 0][cnt+10][rem];
        
        int max = 9;
        
        if(bound){
            max = s.charAt(i) - '0';
        }
        
        int ans = 0;
        for(int j = 0; j<=max; j++){
            int newCnt = cnt;
            if(!isZero || j > 0){
                newCnt += (j%2 == 0 ? 1:-1);
            }            
            ans += f(i+1, bound && j == max, isZero && j==0 , newCnt, (rem*10 + j)%k  );
        }
        return dp[i][bound ? 1 : 0][isZero ? 1 : 0][cnt+10][rem]=  ans;
        
    }
    
}


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>


class Solution {
public:
    int dp[11][2][11][100][11][2];
    int solve(int idx, int edge, int even, int rem, int odd, int zero, string s, int k){
        if(idx == s.length()) {
            if(even == odd && rem == 0 && !zero) return 1;
            return 0;
        }
        if(dp[idx][edge][even][rem][odd][zero] != -1) return dp[idx][edge][even][rem][odd][zero];
        int ans = 0;
        int max_digit = 9;
        if(edge) max_digit = s[idx] - '0';
        for(int i =  0; i<= max_digit; i++){
            // case which i forgot to take is the case of trailing zero. 
            int new_edge = (s[idx] - '0' == i)? edge:0;
            int new_rem = (rem*10 + i) % k;
            int new_odd = odd;
            int new_even = even;
            int new_zero = zero;
            if(!zero || i > 0){
                if(i%2 == 0) new_even += 1;
            }
            if(i%2 == 1) new_odd += 1;
            if(i!= 0 && new_zero) new_zero = 0;
            ans += solve(idx + 1, new_edge, new_even, new_rem, new_odd, new_zero, s, k);
        }
        return dp[idx][edge][even][rem][odd][zero] = ans;
    }
    int numberOfBeautifulIntegers(int low, int high, int k) {
        string s1 = to_string(low - 1);
        string s2 = to_string(high);
        memset(dp, -1, sizeof(dp));
        int ans1 = solve(0, 1, 0, 0, 0, 1, s1, k);
        memset(dp, -1, sizeof(dp)); 
        int ans2 = solve(0, 1, 0, 0, 0, 1, s2, k);
        return ans2 - ans1;
    }
};


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>



class Solution {
public:
    
    int dp[11][21][50][2][2];
    
    int solve(string& num, int n, int diff, int sum, int k, bool leading, bool tight){
        
        if(n == 0){
            if(diff==0 && sum == k) return 1;
            else return 0;
        }
        
        if(dp[n][10+diff][sum][leading][tight] != -1) return dp[n][10+diff][sum][leading][tight];
        
        int ans = 0;
        int ub = tight ? num[num.size()-n]-'0' : 9;
        
        for(int dig = 0; dig<=ub; dig++){
            if(dig == 0 && leading == 1){
                ans += solve(num, n-1, diff, (sum%k)+k, k, 1, 0);
            }
            else{
                int val = 1;
                for(int i=0; i<n-1; i++){
                    val *= 10;
                }
                if(dig%2){
                    ans += solve(num, n-1, diff+1, ((sum+(dig*val))%k)+k, k, 0, (tight&(ub==dig)));
                }
                else{
                    ans += solve(num, n-1, diff-1, ((sum+(dig*val))%k)+k, k, 0, (tight&(ub==dig)));
                }
            }
        }
        return dp[n][10+diff][sum][leading][tight] = ans;
    }
    
    int numberOfBeautifulIntegers(int low, int high, int k) {
        
        string l = to_string(low-1);
        string r = to_string(high);
        
        memset(dp, -1, sizeof(dp));
        int a = solve(l, l.size(), 0, 0, k, 1, 1);
        memset(dp, -1, sizeof(dp));
        int b = solve(r, r.size(), 0, 0, k, 1, 1);
        
        return b-a;
        
    }
};


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>



class Solution {
public:
    #define ll long long
    ll dp[20][2][2][20][20][50];
    int k;
    ll solve(string &s,int n,bool tight,bool isleading,int cnteven,int cntodd,int rem)
    {
        if(n==0)
        {
            if(cnteven==cntodd && rem==0)
            {
                return 1;
            }
            else return 0;
        }
        if(dp[n][tight][isleading][cnteven][cntodd][rem]!=-1) return dp[n][tight][isleading][cnteven][cntodd][rem];
        int lim=tight?s[s.size()-n]-'0':9;
        ll ans=0;
        for(int dig=0;dig<=lim;dig++)
        {
            if(isleading && dig==0)
            {
                ans+=solve(s,n-1,0,isleading&(dig==0),0,0,0);
            }
            else
            {
                if(dig%2==0)
                {
                    ans+=solve(s,n-1,tight&(dig==lim),0,cnteven+1,cntodd,(rem*10+dig)%k);
                }
                else
                {
                    ans+=solve(s,n-1,tight&(dig==lim),0,cnteven,cntodd+1,(rem*10+dig)%k);
                }
            }
        }
        return dp[n][tight][isleading][cnteven][cntodd][rem]=ans;
    }
    int numberOfBeautifulIntegers(int low, int high, int K) {
        k=K;
        memset(dp,-1,sizeof(dp));
        low--;
        string lower=to_string(low);
        ll ansleft=solve(lower,lower.size(),1,1,0,0,0);
        memset(dp,-1,sizeof(dp));
        string higher=to_string(high);
        ll ansright=solve(higher,higher.size(),1,1,0,0,0);
        return ansright-ansleft;
    }
};


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>




class Solution {
public:
    int dp[30][10][2][2][22];
    
    int solve(int neutral, int ind, int tight1, int tight2, int val , string low , string high ,int k, int rem){

// step -2: Write a Base Case
        if( ind == low.size()) {
            if( neutral == 0 and val%k == 0 ){
                return 1;
            }
            return 0;
        }

        if( dp[neutral+10][ind][tight1][tight2][rem] != -1 ){
            return dp[neutral+10][ind][tight1][tight2][rem];
        }
// step -3 : Define loop parameter through tight1 and tight2 
        int start = tight1? low[ind] - '0' : 0;
        int end = tight2? high[ind] - '0' : 9;
        int count = 0;
// step -4 : Run  loop from defined parameter 
        for( int i = start; i<= end; i++ ){

// step -5 : Declare new tight for upcoming recursive call if it was previously a tight and either  a first or last index is i then tight again 
            bool new_t1 = 0, new_t2 = 0 ;
            if( tight1 and start==i ) new_t1 = 1;
            if( tight2 and end==i ) new_t2  =1;
// step -6 : calculate parity using single variable if even add 1 otherwise -1  ignore parity for those whose val is 0 ex: 00004 here parity is 1 
            int parity = i%2? -1: 1;
            if( val == 0 and i == 0 ) parity = 0;
            neutral += parity ;
// step -7 : keep track of remainder
            int new_rem = ( (rem * 10) + i) %k;
            count += solve(neutral,  ind + 1, new_t1, new_t2, val*10+ i, low , high,k, new_rem);
// step -8 : Don't forget to make changes in neutral like we usually do in backtrack 
            neutral = neutral - parity;
            
        }
        return dp[neutral+10][ind][tight1][tight2][rem] = count;
    }
    
    int numberOfBeautifulIntegers(int low, int high, int k) {
        string a = to_string ( low ) ;
        string b = to_string ( high);
        while( b.size() > a.size() ) {
            a = '0' + a;
        }

// Step -1 : Declare and Initialize a dp 
        memset(dp, -1 , sizeof(dp) );
        return solve(0, 0, 1, 1, 0, a, b, k,0 ) ;
    }
};


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>



class Solution {
public:
    int dp[11][11][11][2][21][2];
    
    int solve(string &s, int i, int z, int o, bool tight,int rem, bool flag, int k){
        if(i == s.size()){
            return (flag == false) && (z == o) && (rem == 0);
        }
        if(dp[i][z][o][tight][rem][flag] != -1)return dp[i][z][o][tight][rem][flag];
        int till = (tight) ? s[i] - '0' : 9;
        int ans = 0;
        for(int j=0;j<=till;j++){
            bool newTight = tight && (j == till);
            int newRem = ((rem*10) + j) % k;
            if(flag){
                if(j == 0){
                    ans += solve(s,i+1,z,o,newTight,newRem,true,k);
                }
                else ans += solve(s, i+1, z + (j%2 == 0) , o + (j%2 == 1), newTight,newRem, false, k);
            }
            else{
                ans += solve(s, i+1, z + (j%2 == 0) , o + (j%2 == 1), newTight, newRem, false, k);
            }
        }
        return dp[i][z][o][tight][rem][flag] = ans;        
    }
    
    int numberOfBeautifulIntegers(int low, int high, int k) {
        string s = to_string(high);
        memset(dp, -1, sizeof(dp));
        int ans = solve(s, 0, 0, 0, true, 0, true, k);
        memset(dp, -1, sizeof(dp));
        int nw = low-1;
        s = (to_string(nw));
        ans -= solve(s, 0, 0, 0, true, 0, true, k);
        return ans;
    }
};


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>



class Solution {
public:
    string s="";
    int n;
    int d;
    
    int dp[11][11][21][11][2][2];
//         just for idx  //actual length  //modulo //odd count   in limit 
    int solve(int idx, int len,          int sum, int o,         int li, int z)// z==1 =number is zero
    {
        if(idx==n)
        {
            if(len-o==o && sum==0 && !z ) return 1;
            return 0;
        }
        
        if(dp[idx][len][sum][o][li][z]!=-1) return dp[idx][len][sum][o][li][z];
        
        int mx=9;
        if(li==1) mx= s[idx]-'0'; 
        int ans=0;
        for(int i=0; i<=mx; i++)
        {
            ans+=solve(idx+1,!z||i? len+1:len, (sum*10+ i)%d, o+i%2,li&&(i==mx), z&&(i==0) );
            
        }
        
        return dp[idx][len][sum][o][li][z]=ans;
        
    }
    int numberOfBeautifulIntegers(int low, int high, int k) {
        s=to_string(high);
        d=k;
        n=s.size();
        memset(dp,-1,sizeof(dp));
        int ans=solve(0,0,0,0,1,1);
        s=to_string(low-1);
        n=s.size();
        memset(dp,-1,sizeof(dp));
        ans-=solve(0,0,0,0,1,1);
        return ans;
        
    }
};



// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>



class Solution {
public:
    int numberOfBeautifulIntegers(int low, int high, int k) {
        int beautifulCount = 0;
        int x=low%k;
        if(x!=0){
            low+=k-x;
        }
        if(high>1e8){
            high=1e8;
        }
        for (int num = low; num <= high; num=num+k) {
            if (isBeautiful(num)) {
                beautifulCount++;
            }
        }
        
        return beautifulCount;
    }
    
private:
    bool isBeautiful(int num) {
        int evenCount = 0;
        int oddCount = 0;

        while (num > 0) {
            int digit = num % 10;
            if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            num /= 10;
        }

        return evenCount == oddCount;
    }
};