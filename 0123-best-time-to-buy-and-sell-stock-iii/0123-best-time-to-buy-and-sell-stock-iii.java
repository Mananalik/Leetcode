class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][][] dp = new int[n+1][2][3];
        for(int index=n-1;index>=0;index--){
            int taken  = Integer.MIN_VALUE;
            int notTaken  = Integer.MIN_VALUE;
            for(int buy = 0;buy<2;buy++){
                for(int cap = 1;cap<3;cap++){
                    if(buy==0){
                            taken = -prices[index]+ dp[index+1][1][cap];
                            notTaken = 0+ dp[index+1][0][cap];
                    }
                    if(buy==1){
                        taken = prices[index] + dp[index+1][0][cap-1];
                        notTaken = 0 + dp[index+1][1][cap];
                    }
                    dp[index][buy][cap] = Math.max(taken,notTaken);
                }
            }
        }
        return dp[0][0][2];
    //     for(int x[][]:dp){
    //         for(int y[]:x){
    //             Arrays.fill(y,-1);
    //         }
            
    //     }
    // return func(prices,0,0,2,dp);
    }
    // static int func(int arr[], int index , int buy , int cap,int[][][] dp){
    //     if(index==arr.length){
    //         return 0;
    //     }
    //     if(cap==0){
    //         return 0;
    //     }
    //     if(dp[index][buy][cap]!=-1) return dp[index][buy][cap];
    //     int taken  = Integer.MIN_VALUE;
    //     int notTaken = Integer.MIN_VALUE;
    //     if(buy==0){
    //         taken = -arr[index]+func(arr,index+1,1,cap,dp);
    //         notTaken = 0+func(arr,index+1,0,cap,dp);
    //     }
    //     if(buy==1){
    //         taken = arr[index]+func(arr,index+1,0,cap-1,dp);
    //         notTaken = 0+ func(arr,index+1,1,cap,dp);
    //     }
    //     return dp[index][buy][cap]= Math.max(taken,notTaken);
    // }
}