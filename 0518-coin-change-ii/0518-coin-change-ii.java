class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        return func(n-1,amount,coins,dp);
    }
    static int func(int index , int target , int [] arr , int dp[][]){
        if(index==0){
            if(target%arr[0]==0) return 1;
            else return 0;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int notPick = func(index-1,target,arr,dp);
        int pick =0 ;
        if(arr[index]<=target){
            pick = func(index,target-arr[index],arr,dp);
        }
        return dp[index][target] = pick+notPick;
    }
}