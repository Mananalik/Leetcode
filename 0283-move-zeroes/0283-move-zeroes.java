class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0){
            return;
        }
        int count = 0;
        for(int i : nums){
            if(i!=0){
                nums[count] = i;
                count++;
            }
        }
        while(count<nums.length){
            nums[count] = 0;
            count++;
        }
    }
}