class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int dp[][] = new int[n1][n2];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        return func(n1-1,n2-1,text1,text2,dp);
    }
    static int func(int index1 , int index2 , String text1,String text2,int[][]dp){
        if(index1<0 || index2<0){
            return 0;
        }
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        if(text1.charAt(index1)==text2.charAt(index2)){
            return dp[index1][index2]=( 1+func(index1-1,index2-1,text1,text2,dp));
        }
        else{
            return dp[index1][index2]=(0+Math.max(func(index1-1,index2,text1,text2,dp),func(index1,index2-1,text1,text2,dp)));
        }
    }
}