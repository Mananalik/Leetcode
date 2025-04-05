class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int [n][n+1];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        return func(nums,0,-1,dp);

    }
    static int func(int arr[],int index, int number, int[][] dp){
        if(index==arr.length){
            return 0;
        }
        if(dp[index][number+1]!=-1) return dp[index][number+1];
        int taken = 0;
        int notTaken = 0;
        if(number==-1 || arr[index]>arr[number]){
            taken = 1+ func(arr,index+1,index,dp);
        }
        notTaken = 0+func(arr,index+1,number,dp);
        return dp[index][number+1] =  Math.max(taken,notTaken);
    }
}