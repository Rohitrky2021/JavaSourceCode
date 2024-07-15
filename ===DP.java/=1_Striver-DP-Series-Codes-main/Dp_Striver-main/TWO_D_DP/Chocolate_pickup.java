package TWO_D_DP;

public class Chocolate_pickup {

    //Recursion 
    public static int Rec(int i,int j1,int j2 ,int grid[][],int n,int m){
		
		if(j1<0 || j1==m || j2<0 || j2==m){
			return Integer.MIN_VALUE;
		}
		
		if(i==n-1){
			if(j1==j2){
				return grid[i][j1];
			}
			return grid[i][j1]+grid[i][j2];
		}

	
		int max = Integer.MIN_VALUE ;
		int total =0;
		
		for(int k=-1;k<=1;k++){
			
			for(int l=-1;l<=1;l++){
				if(j1==j2){
					//	Dp(i, j1, j2, grid, n, m)
					int t = Rec(i+1,j1+k,j2+l,grid,n,m);
					if(t!=Integer.MIN_VALUE){
					    total = grid[i][j1]+t;
					}
				
				}
				else{
					int t = Rec(i+1,j1+k,j2+l,grid,n,m);
					if(t!=Integer.MIN_VALUE){
						total = grid[i][j1]+grid[i][j2]+t;
					}
					
				}
				max = Math.max(max,total);
			}
		   
		}

	
		
		return max;
	}

    //Memorization 
    public static int DP(int i,int j1,int j2 ,int grid[][],int n,int m,int dp[][][]){
		
		if(j1<0 || j1==m || j2<0 || j2==m){
			return Integer.MIN_VALUE;
		}
		
		if(i==n-1){
			if(j1==j2){
				return grid[i][j1];
			}
			return grid[i][j1]+grid[i][j2];
		}

		if(dp[i][j1][j2]!=-1){
			return 	dp[i][j1][j2];
		}

		int max = Integer.MIN_VALUE ;
		int total =0;
		
		for(int k=-1;k<=1;k++){
			
			for(int l=-1;l<=1;l++){
				if(j1==j2){
					//	Dp(i, j1, j2, grid, n, m)
					int t = DP(i+1,j1+k,j2+l,grid,n,m,dp);
					if(t!=Integer.MIN_VALUE){
					    total = grid[i][j1]+t;
					}
				
				}
				else{
					int t =  DP(i+1,j1+k,j2+l,grid,n,m,dp);
					if(t!=Integer.MIN_VALUE){
						total = grid[i][j1]+grid[i][j2]+t;
					}
					
				}
				max = Math.max(max,total);
			}
		   
		}

		dp[i][j1][j2] = max;
		
		return max;
	}
    public static void main(String[] args) {
        
    }
}
