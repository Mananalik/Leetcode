class Solution {
    public int maxProfit(int[] prices) {
        int n  = prices.length;
        int dp[][] = new int[n][2];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
    return func(prices,0,0,dp);
    }
    static int func(int arr[],int index, int buy,int[][] dp){
        if(index==arr.length){
            return 0;
        }
        int taken = Integer.MIN_VALUE;
        int notTaken = Integer.MIN_VALUE;
        if(dp[index][buy]!=-1) return dp[index][buy];
        if(buy==0){
            notTaken =0+ func(arr,index+1,0,dp);
             taken = -arr[index] + func(arr,index+1,1,dp);
        }
        if(buy==1){
             notTaken = 0+func(arr,index+1,1,dp);
             taken = arr[index]+func(arr,index+1,0,dp);
        }
        return dp[index][buy]= Math.max(taken,notTaken);
    }
}