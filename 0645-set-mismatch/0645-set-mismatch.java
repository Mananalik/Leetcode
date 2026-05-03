class Solution {
    public int[] findErrorNums(int[] nums) {
        int ans[] = new int[2];
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!st.contains(nums[i])){
                st.add(nums[i]);
            }else{
                ans[0] = nums[i];
            }
        }
        for(int i=1;i<=n;i++){
            if(!st.contains(i)) ans[1] = i;
        }
        return ans;
    }
}