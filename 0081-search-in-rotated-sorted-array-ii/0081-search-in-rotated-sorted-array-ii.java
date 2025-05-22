class Solution {
    public boolean search(int[] nums, int target) {
    int s=0;
    int e = nums.length-1;
    while(s<=e){
        int mid = s+(e-s)/2;
        if(target==nums[mid]){
            return true;
        }
        if(nums[s]==nums[mid] && nums[e]==nums[mid]){
            s=s+1;
            e=e-1;
            continue;
        }
       if(nums[s]<=nums[mid]){
            if(target>=nums[s] && target<=nums[mid]){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }else{
            if(target>=nums[mid]&& target<=nums[e]){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
    }
    return false;
    }
}