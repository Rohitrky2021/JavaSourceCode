package question;

public class singl {
    public static int single(int[] num) {
        if(num.length==1){
            return num[0];
        }
        int ans=1;
        for(int i=0; i< num.length-1;i++){
            int temp=0;
            for(int j=0; j<num.length;j++){
                if(i==j)continue;
                if(num[i]==num[j]){
                    temp++;
                    System.out.println(temp);
                    break;
                }      
            }    
            if(temp == 0){
                ans = num[i];
                break;
            }     
        }
        return ans;
    }
    public static void main(String[] args) {
        int num[] = {1,2,3,3,4,2,1};
        int ans  =  single(num);
        System.out.print(ans);
    }
}
