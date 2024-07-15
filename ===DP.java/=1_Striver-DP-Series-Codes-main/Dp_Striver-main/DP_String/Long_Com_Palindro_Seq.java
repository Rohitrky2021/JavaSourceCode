package DP_String;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Long_Com_Palindro_Seq {

    //Question -- Longest common Palindrome Sub-sequence**
    //Follow Up --  Longest common  Sub-sequence**

    //Space Optimization --tc-0(N*M) ,SC - 0(M)
    public static int Space(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[]= new int [m+1];

        for(int i1=1;i1<=n;i1++){
            int curr[] = new int [m+1];
            for(int i2=1;i2<=m;i2++){
                int match =0;
                if(s1.charAt(i1-1)==s2.charAt(i2-1)){
                    match = 1 ;
                    if(i1-1>=0 && i2-1>=0 ){
                        match = 1+dp[i2-1] ;
                    }
                    curr[i2] = match;
                } else {
                    int one = 0;
                    int two = 0;
                    if(i1-1>=0 && i2-1>=0 ){
                        one = 0+ dp[i2];
                        two = 0+ curr[i2-1];
                    }
                    int max = Math.max(one,two);
                    curr[i2] = max;
                }
            }
            dp = curr;
        }
        return dp[m];
    }

    public static void main(String[] args) {
        String str = "bbabcbcab";
        StringBuffer str2 = new StringBuffer();
        str2.append(str);
        str2.reverse();
        System.out.println(Space(str, str2.toString()));
    }
}
