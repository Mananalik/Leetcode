class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int i: nums) sum+=i;
        if(sum%2!=0) return false;
        int target = sum/2;
        int dp[][] = new int[n][target+1];
        for(int i[]: dp){
            Arrays.fill(i,-1);
        }
        return func(n-1,target,nums,dp);
    }
    public boolean func(int index, int target, int [] arr, int [][] dp){
        if(target==0) return true;
        if(index==0) return arr[index]==target;
        if(dp[index][target]!=-1) return dp[index][target]==1;
        boolean notTaken = func(index-1,target,arr,dp);
        boolean taken = false;
        if(target>=arr[index]){
            taken = func(index-1,target-arr[index],arr,dp);
        }
        dp[index][target] = (taken || notTaken)?1:0;
        return taken|| notTaken;
    }
}