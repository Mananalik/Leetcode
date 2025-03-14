class Solution {
    public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    for(int []x:dp){
        Arrays.fill(x,-1);
    }
    return func(m-1,n-1,grid,dp);
    }
    static int func(int i , int j, int[][] grid , int[][] dp){
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(i<0 || j<0){
            return (int) Math.pow(10,9);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int up = grid[i][j] + func(i-1,j,grid,dp);
        int left = grid[i][j] + func(i,j-1,grid,dp);
        return dp[i][j] = Math.min(up,left);
    }
}