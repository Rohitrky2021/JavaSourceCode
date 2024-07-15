class Solution {
    public int maxScore(String s) {
        int count[]=new int[s.length()];
       char ans[]=s.toCharArray();
       int c=0,max=Integer.MIN_VALUE;


       for (int i = ans.length-1; i >=0; i--) {
        if(ans[i]=='1'){
            count[i]=c++;
        }
       }

      for (int i = ans.length-1; i >=0; i--) {
       max=Math.max(max, ans.length-i+count[i]);
    }
    return  max;
}

}
// Input: s = "011101"
// Output: 5