class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int [] x: dp){
            Arrays.fill(x,-1);
        }
        return countPath(m-1,n-1,dp);
    }
    static int countPath(int i , int j , int[][] dp){
        if(i==0 && j==0) {
            return 1;
        }
        if(i<0 || j<0 ){
            return 0;
        }
        if(dp[i][j] !=-1) return dp[i][j];
        int up = countPath(i-1,j,dp);
        int left =  countPath(i,j-1,dp);
        return dp[i][j] = up+left;
    }
}