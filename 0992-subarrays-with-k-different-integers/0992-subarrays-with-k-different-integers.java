class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }
    public int atMost(int[] nums, int k){
        if(k<0) return 0;
        int cnt = 0;
        int l = 0;
        int r =  0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        while(r<nums.length){
            mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);
            while(mp.size()>k){
                mp.put(nums[l],mp.get(nums[l])-1);
                if(mp.get(nums[l])==0) mp.remove(nums[l]);
                l++;
            }
           cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
}