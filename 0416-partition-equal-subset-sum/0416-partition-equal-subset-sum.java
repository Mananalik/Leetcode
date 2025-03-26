class Solution {
    public boolean canPartition(int[] nums) {
        int sum  = 0;
        int n = nums.length;
      
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
          int dp[][] = new int[n][target+1];
          for(int x[]: dp){
            Arrays.fill(x,-1);
          }
        return func(n-1, target,nums,dp);
    }
    static boolean func(int index , int target , int arr[], int dp[][]){
        if(target==0) return true;
        if(index==0) return arr[index]==target;
        if(dp[index][target]!=-1){
            return dp[index][target]==0?false:true;
        }
        boolean notPick = func(index-1, target, arr,dp);
        boolean pick = false;
        if(arr[index]<=target){
            pick = func(index-1, target-arr[index], arr,dp);
        }
        dp[index][target] = pick || notPick ? 1:0;
        return pick || notPick;
    }
}