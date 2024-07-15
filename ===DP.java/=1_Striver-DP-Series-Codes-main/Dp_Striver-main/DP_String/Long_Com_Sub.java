package DP_String;

public class Long_Com_Sub {

    //Question -- Longest Common Sub-string ****
    //Follow up - Longest Comon sub-Sequence*


    //Tabulation ---- TC-0(N*M) ,SC-0(N*M)
    public static int lcs(String s1, String s2) {
		
		int n = s1.length();
		int m = s2.length();

		int dp[][] = new int [n+1][m+1];
		int ans =0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					int match = 1+dp[i-1][j-1];
					dp[i][j] = match;
                    //Every time calculate max 
					ans = Math.max(ans,match);
				}
				else{
                    //In LCS here modify but here sub-string in continious manner so if not match 0
					dp[i][j] = 0;
				}
			}
		}

		return ans ;
	}


    //Space Optimization --tc-0(N*M) , Sc -0(M)
    public static int Space(String s1, String s2) {
		
		int n = s1.length();
		int m = s2.length();

		int dp[] = new int [m+1];
		int ans =0;
		for(int i=1;i<=n;i++){
			int curr[] = new int [m+1];
			for(int j=1;j<=m;j++){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					int match = 1+dp[j-1];
					curr[j] = match;
					ans = Math.max(ans,match);
				}
				else{
					curr[j] = 0;
				}
			}
			dp = curr;
		}

		return ans ;
	}


    public static void main(String[] args) {
        
    }
}
