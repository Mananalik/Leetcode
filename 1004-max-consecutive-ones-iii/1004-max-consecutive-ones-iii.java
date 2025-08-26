class Solution {
    public int longestOnes(int[] nums, int k) {


        // Slightly optimized 
        int n = nums.length;
        int l=0;
        int r=0;
        int maxLen=0;
        int zeroes=0;
        while(r<n){
            if(nums[r]==0){
                zeroes++;
            }
            while(zeroes>k){
                if(nums[l]==0){
                    zeroes--;
                    
                }
                l++;
            }
            if(zeroes<=k){
                int len = r-l+1;
                maxLen = Math.max(len,maxLen);
            }
            r++;
        }
        return maxLen;
        // Brute Force // 2 pointers
        // int n = nums.length;
        // int maxLen = 0;
        // for(int i=0;i<n;i++){
        //     int zeroes=0;
        //     for(int j=i;j<n;j++){
        //         if(nums[j]==0){
        //             zeroes++;
        //         }
        //         if(zeroes<=k){
        //             int len = j-i+1;
        //             maxLen = Math.max(maxLen,len);
        //         }else{
        //             break;
        //         }
        //     }
        // }
        // return maxLen;
    }
}