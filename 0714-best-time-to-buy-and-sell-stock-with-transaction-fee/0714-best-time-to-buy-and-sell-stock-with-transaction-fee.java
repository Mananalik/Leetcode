class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        return func(prices,0,0,fee,dp);
    }
    static int func(int [] arr , int index, int buy , int fee, int[][] dp){
        if(index==arr.length){
            return 0;
        }
        if(dp[index][buy]!=-1) return dp[index][buy];
        if(buy==0){
            return dp[index][buy] = Math.max((-arr[index]+func(arr,index+1,1,fee,dp)),(0+func(arr,index+1,0,fee,dp)));
        }else{
            return dp[index][buy]= Math.max((arr[index]-fee+func(arr,index+1,0,fee,dp)),(0+func(arr,index+1,1,fee,dp)));

        }
    }
}