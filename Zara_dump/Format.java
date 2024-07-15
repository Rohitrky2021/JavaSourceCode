class Solution {
    public String minimumString(String a, String b, String c) {


        int fre[]=new int[256];

        String ans[]=new String[3];
        ans[0]=a; ans[1]=b; ans[2]=c;
        Arrays.sort(ans);
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            fre[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
           fre[b.charAt(i)]++;
           }
        for (int i = 0; i < c.length(); i++) {
              fre[b.charAt(i)]++;
         }

         for (int i = 0; i < ans.length; i++) {
            for(char c : ans[i]) {
                 if(ans[i+1].contains(c+""));
            }
         }




        
    }

}