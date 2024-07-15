class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        String s=new String(Integer.toString(x));
        char arr[]=s.toCharArray();
        int sum=0;
        for(char m:arr){
            sum+=m-'0';
        }

        if(x%sum==0)return sum;

        return -1;
    }
}