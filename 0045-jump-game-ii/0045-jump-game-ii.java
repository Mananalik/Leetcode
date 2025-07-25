class Solution {
    public int jump(int[] nums) {
        int r = 0;
        int l = 0;
        int jmp = 0;
        int n = nums.length;
        while(r<n-1){
            int farthest = 0;
            for(int i=l;i<=r;i++){
                farthest = Math.max(i+nums[i],farthest);
            }
            l = r+1;
            r = farthest;
            jmp++;
        }
        return jmp;
    }
}