class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {

        ArrayList<Integer> ans=new ArrayList<>();
        int n=0;
        for(String i:words){

           if( i.contains(String.valueOf(x)))ans.add(n);
           n++;
      }

      return ans;
        
    }
}