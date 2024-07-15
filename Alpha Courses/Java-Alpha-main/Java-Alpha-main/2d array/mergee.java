public class mergee {
    public static int[] merge(int[] num1,int[] num2){
        int ans[] = new int[num1.length + num2.length]; 
        int x = 0,i = 0 , j = 0; 
        while( x < 6){
            if(num1[i]<=num2[j]){
                System.out.println("at num1");
                ans[x]=num1[i];
                if( i < num1.length-1 /*3*/){
                    i++;
                }
            }
            else if(num1[i]>num2[j]){
                System.out.println("at num2");
                ans[x]=num2[j];
                if(j < num2.length-1 /*3*/){
                    j++;
                }           
            }
            x++;
        }
        ans[ans.length-1]= num1[i]>num2[j]?num1[i]: num2[j];
        int l = ans.length;
        System.out.println(l);
        for(int k=0;k<ans.length;k++){
            System.out.print(ans[k]);
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int num1[] = {1,3,5,7,9};
        int num2[] = {2,4,6,8};
        int ans[] = merge(num1,num2);               
    }    
}
