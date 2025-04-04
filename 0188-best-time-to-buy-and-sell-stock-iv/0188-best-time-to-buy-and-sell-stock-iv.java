class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2*k+1];
        for(int i = 0;i<=2*k;i++){
            dp[n][i] = 0;
        }
        for(int i=0;i<n-1;i++){
            dp[i][2*k] = 0;
        }
        int profit = 0;
        for(int index = n-1;index>=0;index--){
            for(int transection = 2*k-1;transection>=0;transection--){
                if(transection%2==0){
                    profit = Math.max((-prices[index]+dp[index+1][transection+1]),(dp[index+1][transection]));
                }else{
                     profit = Math.max((prices[index]+dp[index+1][transection+1]),(dp[index+1][transection]));
                }
                dp[index][transection] = profit;
            }
           
        }
        return dp[0][0];
        // for(int x[]:dp){
        //     Arrays.fill(x,-1);
        // }
        // return func(prices,0,0,k,dp);
    }

    //MEMOIZATION 


    // static int func(int arr[] , int index, int transection , int k, int [][] dp){
    //         if(index==arr.length || transection==2*k){
    //             return 0;
    //         }
    //         if (dp[index][transection]!=-1) return dp[index][transection];
    //         if(transection %2==0){
    //             return dp[index][transection] = Math.max((-arr[index]+func(arr,index+1,transection+1,k,dp)),(0+func(arr,index+1,transection,k,dp)));
    //         }else{
    //             return dp[index][transection] = Math.max((arr[index]+func(arr,index+1,transection+1,k,dp)),(0+func(arr,index+1,transection,k,dp)));
    //         }
    // }
}