class Solution {
    public int search(int[] nums, int target) {
      int s= 0;
      int e = nums.length-1;
      return find(nums , target , s , e);
}
static int find(int [] nums , int target , int s , int e ){
        if(s>e){
            return -1;
        }
        int mid = s + (e - s) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            e = mid - 1;
            return find(nums, target, s, e);
        }
        return  find(nums, target, mid+1, e);
}
}