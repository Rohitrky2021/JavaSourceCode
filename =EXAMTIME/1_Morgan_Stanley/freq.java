 
class freq {   
    public String frequencySort(int arr[],String st) {
        int ans[]=new int[st.length()];
       int sum = 0;
         
        for (char c : st.toCharArray()) {
            charFreq[c][0] = c; 
            charFreq[c][1]=arr[c-'a'];     
        }
        
        Arrays.sort(charFreq, (a, b) -> b[1] - a[1]);  
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            if(charFreq[i][1]!=0)ans[j++]=charFreq[i][1];
        }

        for (int i = 1; i < ans.length; i++) {
            sum=Math.abs(ans[i]-ans[i-1]);
        }


        
       
        return sum;
    }
 
}