class Solution {
    public int missingNumber(int[] nums) {
    Arrays.sort(nums);
        int i = 0;
        int a = 0;
        int count = 0;
        if(nums.length==1 && nums[0]!=0){
            return 0;
        }
        while (i < nums.length) {
            if (nums[i] != i) {
                a = i;
                count++;
                break;
            }
            i++;
        }
        if(i==nums.length && a==0 && count==0){
            a = nums.length;
        }
        return a;
    }
}