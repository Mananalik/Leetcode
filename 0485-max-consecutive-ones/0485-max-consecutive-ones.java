class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                maxi = Math.max(cnt,maxi);
                cnt = 0;

            }else{
                cnt++;
            } 
            
        }
        maxi = Math.max(maxi,cnt);
        return maxi;
    }
}