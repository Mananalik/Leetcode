class Solution {
    public int coinChange(int[] coins, int amount) {
        int n  = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        int ans =func(n-1,amount,coins,dp);
        if(ans>=(int) 1e9){
            return -1;
        }
        return ans;
    }
    static int func(int index , int target , int arr[], int [][] dp){
        if(index==0){
            if(target%arr[0]==0) return target/arr[0];
            else return (int)1e9;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int notPick = 0+func(index-1,target, arr,dp);
        int pick = (int) 1e9;
        if(arr[index]<=target){
            pick = 1+func(index,target-arr[index],arr,dp);
        }
        return dp[index][target]=Math.min(pick,notPick);
    }
}