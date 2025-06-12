class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int ans[] = new int[n1];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int nums:nums2){
            while(!st.isEmpty() && nums>st.peek()){
                mp.put(st.pop(),nums);
            }
            st.push(nums);
        }
        int i=0;
        for(int nums:nums1){
            ans[i++] = mp.getOrDefault(nums,-1);
        }
        return ans;
    }
}