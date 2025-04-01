class Solution {
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int dp[][] = new int[n1][n2];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        return func(s,t,n1-1,n2-1,dp);
    }
    static int func(String s , String t , int i , int j , int[][] dp){
        if(j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
           return dp[i][j] =  func(s,t,i-1,j-1,dp) + func(s,t,i-1,j,dp);
        }
        return dp[i][j] = func(s,t,i-1,j,dp);
    }

}