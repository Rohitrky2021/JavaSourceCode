public class sort{
    public static int[] plusOne(int[] digits) {
        if(digits[digits.length-1]+1 < 10){
            digits[digits.length-1] += 1;
            return digits;
        }
        else{
            int sum = 0;
            int count =0;
            for(int i=0;i<digits.length;i++){
                sum = sum*10+digits[i];
                count = count*10+9;
            }
            sum +=1;
            if(sum <= count){
            
            int i = digits.length-1;
            while(sum!=0){
                int temp = sum%10;
                digits[i]=temp;
                i--;
                sum=sum/10;
            }
            return digits;
        }else{
                int arr[] = new int  [digits.length+1];
                int i = arr.length-1;
                while(sum!=0){
                    int temp = sum%10;
                    arr[i]=temp;
                    i--;
                    sum=sum/10;
                }
                return arr;
                
            }
        }

 }
          
    
    public static void main(String[] args) {
        int arr[] = {9};
        int ans[] =  plusOne(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]);
        }
    }
    
}

