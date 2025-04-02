class Solution {
    public boolean isMatch(String s, String p) {
        int n1 = p.length();
        int n2 = s.length();
        Boolean dp[][] = new Boolean[n1][n2];
        return func(p,s,n1-1,n2-1,dp);
    }
    static boolean func(String p , String s , int i , int j,Boolean [][] dp){
        if(i<0 && j<0){
            return true;
        }
        if(i<0 && j>=0){
            return false;
        }
        if(i>=0 && j<0){
            for(int index = 0;index<=i;index++){
                if(p.charAt(index)!='*') return false;
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        if(p.charAt(i)==s.charAt(j) || p.charAt(i)=='?'){
            return dp[i][j] = func(p,s,i-1,j-1,dp);
        }
        if(p.charAt(i)=='*'){
            return dp[i][j] = (func(p,s,i-1,j,dp) || func(p,s,i,j-1,dp));
        }
        return dp[i][j]=false;
    }
}