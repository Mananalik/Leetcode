class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                st.pop();
            }
            pse[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            nse[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int maxi = 0;
        for(int i=0;i<n;i++){
            maxi = Math.max(maxi,heights[i]*(nse[i]-pse[i]-1));
        }
        return maxi;
    }
}