public class Knapsack01usingrecursion {
    static int count=0;
    public static int knapsack(int val[],int wt[],int W,int n){
        
        if(W==0 || n==0){
            count++;
            return 0;
        }
        //we are travelling from end to first
        if(wt[n-1]<= W){
            // include
          int ans1= val[n-1] + knapsack(val,wt,W-wt[n-1], n-1);

            // exclude
          int ans2=  knapsack(val, wt, W, n-1);
          return Math.max(ans1, ans2);
        }
        else{//not valid
            return knapsack(val, wt, W, n-1);
        }

       
    }

    public static void main(String args[]){
        int val[]={1,2,3};
        int wt[]={1,2,3};
        int W =4;
        
        System.out.println(knapsack(val,wt,W,3));
        System.out.println(count);
    }
}
