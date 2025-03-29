import java.util.*;
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // Map<Integer,Integer> dp = new HashMap<>();
        // dp.put(0,1);
        // for(int num:nums){
        //     // Temporary map to store new dp states for the current iteration
        //     Map<Integer,Integer> nextDp = new HashMap<>();
        //     for(int sum:dp.keySet()){
        //         int count  = dp.get(sum);
        //         nextDp.put(sum+num,nextDp.getOrDefault(sum+num,0)+count);
        //         nextDp.put(sum-num,nextDp.getOrDefault(sum-num,0)+count);
        //     }
        //     dp = nextDp;
        // }
        
        // return dp.getOrDefault(target,0);
        int n  = nums.length;
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        if(totalSum-target<0) return 0;
        if((totalSum-target)%2==1) return 0;
        int T = (totalSum-target)/2;
        int dp[][]=  new int[n][T+1];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
       return func(n-1,T,nums,dp);

    }
    static int func(int index , int target , int [] arr , int[][] dp){
        if(index==0){
            if(target==0 && arr[0]==0){
                return 2;
            }
            if(target==0 || target==arr[0]){
                return 1;
            }
            return 0;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int notPick = func(index-1,target,arr,dp);
        int pick = 0;
        if(arr[index]<=target){
            pick = func(index-1,target-arr[index],arr,dp);
        }
        return dp[index][target] = pick+notPick;
    }
}