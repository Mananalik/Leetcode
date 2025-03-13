class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int [] x: dp){
            Arrays.fill(x,-1);
        }
        return func(m-1,n-1,dp,obstacleGrid);
    }
    static int func(int i , int j , int[][] dp , int grid[][]){
        if(i>=0 && j>=0 && grid[i][j]==1){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if (dp[i][j]!=-1) return dp[i][j];
        int up = func(i-1,j,dp,grid);
        int left = func(i,j-1,dp,grid);
        return dp[i][j] = left+up;
    }
}