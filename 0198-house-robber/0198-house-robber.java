class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        int index = n-1;
      return  func( index , nums , dp);
    }
    static int func(int index , int [] nums , int[] dp){
            if(index<0) return 0;
            if(index==0) return nums[index];
            if(dp[index]!=-1) return dp[index];
         
            int pick = nums[index] + func(index-2 , nums , dp);
            int notPick =func(index-1 , nums, dp);
            return dp[index] = Math.max(pick,notPick);
                }
}