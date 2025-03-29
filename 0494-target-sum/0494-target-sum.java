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


        // //Tabulation
        //     int n  = nums.length;
        // int totalSum = 0;
        // for(int i=0;i<n;i++){
        //     totalSum+=nums[i];
        // }
        // if(totalSum-target<0) return 0;
        // if((totalSum-target)%2==1) return 0;
        // int T = (totalSum-target)/2;
        // int dp[][]=  new int[n][T+1];
        // if(nums[0]==0){
        //     dp[0][0] = 2;
        // }else{
        //     dp[0][0] = 1;
        // }
        // if(nums[0]!=0 && nums[0]<=T){
        //     dp[0][nums[0]]= 1;
        // }
        // for(int index = 1;index<n;index++){
        //     for(int prey = 0;prey<=T;prey++){
        //         int notPick = dp[index-1][prey];
        //         int pick = 0;
        //         if(nums[index]<=prey){
        //             pick = dp[index-1][prey-nums[index]];
        //         }
        //         dp[index][prey] = pick+notPick;
        //     }

        // }
        // return dp[n-1][T];



        //-------->TABULATION WITH SPACE OPTIMIZATION-------------->

         int n  = nums.length;
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        if(totalSum-target<0) return 0;
        if((totalSum-target)%2==1) return 0;
        int T = (totalSum-target)/2;
        int prev[]=  new int[T+1];
        int curr[]  = new int[T+1];
        if(nums[0]==0){
            prev[0] = 2;
        }else{
            prev[0] = 1;
        }
        if(nums[0]!=0 && nums[0]<=T){
            prev[nums[0]]= 1;
        }
        for(int index = 1;index<n;index++){
            for(int prey = 0;prey<=T;prey++){
                int notPick = prev[prey];
                int pick = 0;
                if(nums[index]<=prey){
                    pick = prev[prey-nums[index]];
                }
                curr[prey] = pick+notPick;
            }
            prev = curr.clone();
        }
        return prev[T];
    //     int n  = nums.length;
    //     int totalSum = 0;
    //     for(int i=0;i<n;i++){
    //         totalSum+=nums[i];
    //     }
    //     if(totalSum-target<0) return 0;
    //     if((totalSum-target)%2==1) return 0;
    //     int T = (totalSum-target)/2;
    //     int dp[][]=  new int[n][T+1];
    //     for(int x[]:dp){
    //         Arrays.fill(x,-1);
    //     }
    //    return func(n-1,T,nums,dp);

    }

    // MEMOIZATION


    // static int func(int index , int target , int [] arr , int[][] dp){
    //     if(index==0){
    //         if(target==0 && arr[0]==0){
    //             return 2;
    //         }
    //         if(target==0 || target==arr[0]){
    //             return 1;
    //         }
    //         return 0;
    //     }
    //     if(dp[index][target]!=-1) return dp[index][target];
    //     int notPick = func(index-1,target,arr,dp);
    //     int pick = 0;
    //     if(arr[index]<=target){
    //         pick = func(index-1,target-arr[index],arr,dp);
    //     }
    //     return dp[index][target] = pick+notPick;
    // }
}