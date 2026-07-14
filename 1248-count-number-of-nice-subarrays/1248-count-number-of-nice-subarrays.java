class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);        
    }
    public int atMost(int[] nums , int k){
        if(k<0) return 0;
        int cnt=0;
        int odds = 0;
        int l = 0;
        int r = 0;
        while(r<nums.length){
            if(nums[r]%2!=0) odds++;
            while(odds>k){
                if(nums[l]%2!=0) odds--;
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
}