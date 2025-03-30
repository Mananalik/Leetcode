class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();
        int prev[] = new int[n2+1];
        int curr[] = new int[n2+1];
        for(int j = 0;j<=n2;j++){
            prev[j] = 0;
        }
        for(int i=1;i<=n1;i++){
            for(int j = 1;j<=n2;j++){
                 if(text1.charAt(i-1)==text2.charAt(j-1)){
             curr[j]=1+prev[j-1];
        }else{
             curr[j]=Math.max(prev[j],curr[j-1]);
        }
            }
            prev = curr.clone();
        }
        // int n1 = text1.length();
        // int n2 = text2.length();
        // int dp[][] = new int[n1+1][n2+1];
        // for(int x[]:dp){
        //     Arrays.fill(x,-1);
        // }
        // return func(n1,n2,text1,text2,dp);
        return prev[n2];
    }

    // MEMOIZATION

    // static int func(int index1 , int index2 , String text1,String text2,int[][]dp){
    //     if(index1==0 || index2==0){
    //         return 0;
    //     }
    //     if(dp[index1][index2]!=-1) return dp[index1][index2];
    //     if(text1.charAt(index1-1)==text2.charAt(index2-1)){
    //         return dp[index1][index2]=( 1+func(index1-1,index2-1,text1,text2,dp));
    //     }
    //     else{
    //         return dp[index1][index2]=(0+Math.max(func(index1-1,index2,text1,text2,dp),func(index1,index2-1,text1,text2,dp)));
    //     }
    // }
}