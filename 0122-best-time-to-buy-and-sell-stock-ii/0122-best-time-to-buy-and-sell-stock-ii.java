class Solution {
    public int maxProfit(int[] prices) {

    int n  = prices.length;
        int ahead[] = new int[2];
        int curr[] = new int[2];
        ahead[0] = 0;
        ahead[1] = 0;
        for(int i=n-1;i>=0;i--){
            int taken = Integer.MIN_VALUE;
            int notTaken  =  Integer.MIN_VALUE;
            for(int j=0;j<=1;j++){
                if(j==0){
                    taken = -prices[i]+ahead[1];
                    notTaken = 0+ahead[0];
                }
                if(j==1){
                    taken = prices[i]+ahead[0];
                    notTaken = 0+ahead[1];
                }
                curr[j] = Math.max(taken,notTaken);
            }
            ahead = curr;
        }
        return curr[0];


        // Tabulation without space optimization
        // int n  = prices.length;
        // int dp[][] = new int[n+1][2];
        // dp[n][0] = 0;
        // dp[n][1] = 0;
        // for(int i=n-1;i>=0;i--){
        //     int taken = Integer.MIN_VALUE;
        //     int notTaken  =  Integer.MIN_VALUE;
        //     for(int j=0;j<=1;j++){
        //         if(j==0){
        //             taken = -prices[i]+dp[i+1][1];
        //             notTaken = 0+dp[i+1][0];
        //         }
        //         if(j==1){
        //             taken = prices[i]+dp[i+1][0];
        //             notTaken = 0+dp[i+1][1];
        //         }
        //         dp[i][j] = Math.max(taken,notTaken);
        //     }
        // }
        // return dp[0][0];





    //     for(int x[]:dp){
    //         Arrays.fill(x,-1);
    //     }
    // return func(prices,0,0,dp);
    }

    // MEMOIZATION
    // static int func(int arr[],int index, int buy,int[][] dp){
    //     if(index==arr.length){
    //         return 0;
    //     }
    //     int taken = Integer.MIN_VALUE;
    //     int notTaken = Integer.MIN_VALUE;
    //     if(dp[index][buy]!=-1) return dp[index][buy];
    //     if(buy==0){
    //         notTaken =0+ func(arr,index+1,0,dp);
    //          taken = -arr[index] + func(arr,index+1,1,dp);
    //     }
    //     if(buy==1){
    //          notTaken = 0+func(arr,index+1,1,dp);
    //          taken = arr[index]+func(arr,index+1,0,dp);
    //     }
    //     return dp[index][buy]= Math.max(taken,notTaken);
    // }
}