class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int s = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int e = max;
        while(s<=e){
            int mid = s+(e-s)/2;
            int sum = func(nums,mid);
            if(sum<=threshold){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return s;
    }
static int func(int [] arr , int mid){
        int sum =0;
        for(int i=0;i<arr.length;i++){
            sum+=Math.ceil((double)arr[i]/(double)mid);
        }
        return sum;
    }
}