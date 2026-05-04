class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> st = new HashSet<>();
        for(int i : nums){
            if(!st.contains(i)) st.add(i);
        }
        int n = nums.length;
        for(int i=1;i<=n;i++){
            if(!st.contains(i)) ans.add(i);
        }
        return ans;
    }
}