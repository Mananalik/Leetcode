class Solution {
    public void moveZeroes(int[] nums) {
        int index_zero = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i]!=0){
                nums[index_zero] = nums[i];
                index_zero++;
            }
        }
        for(int i = index_zero;i<nums.length;i++){
            nums[i] = 0;
        }
    }
}