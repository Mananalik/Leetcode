class Solution {
    public int minDistance(String word1, String word2) {
        int n1= word1.length();
        int n2 = word2.length();
        int dp[][] = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            dp[i][0] = i;
        }
        for(int j =0;j<=n2;j++){
            dp[0][j] = j;
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }

            }
        }
        return dp[n1][n2];
    //     for(int x[]:dp){
    //         Arrays.fill(x,-1);
    //     }
    //  return   func(word1,word2,n1,n2,dp);
    }

    // MEMOIZATION

    // static int func(String s1, String s2 , int i, int j, int[][] dp){
    // if(i==0){
    //     return j;
    // }
    // if(j==0){
    //     return i;
    // }
    // if(dp[i][j]!=-1) return dp[i][j];
    //  if(s1.charAt(i-1)==s2.charAt(j-1)){
    //    return dp[i][j] =  func(s1,s2,i-1,j-1,dp);
    //  }
    //  else{
    //     // 1.  Insert
    //     // 2. delete
    //     // 3. replace
    //   return dp[i][j] = 1+ Math.min(func(s1,s2,i,j-1,dp),Math.min(func(s1,s2,i-1,j,dp),func(s1,s2,i-1,j-1,dp)));
        
    //  }
    // }
}