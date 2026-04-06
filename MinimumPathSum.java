//top-down
class Solution {
    public int solve(int[][] grid,int i,int j,int m,int n,int [][] dp){
        if(i==m-1 && j==n-1){
            return dp[i][j]=grid[i][j];
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(i==m-1){
            return dp[i][j]=grid[i][j]+solve(grid,i,j+1,m,n,dp);
        }
        else if(j==n-1){
            return dp[i][j]=grid[i][j]+solve(grid,i+1,j,m,n,dp);
        }
        else{
            return dp[i][j]=grid[i][j]+Math.min(solve(grid,i+1,j,m,n,dp),solve(grid,i,j+1,m,n,dp));
        }
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int [][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        return solve(grid,0,0,m,n,dp);
    }
}

//bottom-up
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int [][] dp=new int[m][n];
        dp[0][0]=grid[0][0];

        for(int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }

        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }
}
