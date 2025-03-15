class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n  = matrix.length;
        int min = Integer.MAX_VALUE;
        int dp[][] = new int[n][n];
        // for(int [] row:dp){
        //     Arrays.fill(row,-1);
        // }
        for(int j = 0;j<n;j++){
          dp[0][j] = matrix[0][j];
        }
        for(int i = 1 ;i<n;i++){
            for(int j = 0;j<n;j++){
                int dl = matrix[i][j];
               
                int down = matrix[i][j] + dp[i-1][j];
                if(j-1>=0){
                    dl+= dp[i-1][j-1];
                }else{
                    dl = (int) 1e9;
                }
                int dr = matrix[i][j];
                if(j+1<n){
                     dr+= dp[i-1][j+1];
                }else{
                    dr = (int) 1e9;
                }
                dp[i][j] = Math.min(down,Math.min(dl,dr));
            }
        }
        for(int j = 0;j<n;j++){
            min = Math.min(min , dp[n-1][j]);
        }
        return min;
    }
    // memoization 

    // static int func(int i ,int j ,int[][] matrix, int[][] dp){
    //     if(j<0 || j>matrix.length-1){
    //         return (int) 1e9;
    //     }
    //     if(i==0){
    //         return matrix[i][j];
    //     }
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int down = matrix[i][j] + func(i-1,j,matrix,dp);
    //     int dl = matrix[i][j] + func(i-1,j-1,matrix,dp);
    //     int dr = matrix[i][j] + func(i-1,j+1,matrix,dp);

    //     return dp[i][j] = Math.min(down,Math.min(dl,dr));
    // }
}