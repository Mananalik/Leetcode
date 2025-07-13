class Solution {
    public int largestRectangleArea(int[] heights) {
        // int n = heights.length;
        // int nse[] = new int[n];
        // int pse[] = new int[n];
        // Stack<Integer> st = new Stack<>();
        // for(int i=0;i<n;i++){
        //     while(!st.isEmpty() && heights[i]<heights[st.peek()]){
        //         st.pop();
        //     }
        //     pse[i] = st.isEmpty()?-1:st.peek();
        //     st.push(i);
        // }
        // st = new Stack<>();
        // for(int i=n-1;i>=0;i--){
        //     while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
        //         st.pop();
        //     }
        //     nse[i] = st.isEmpty()?n:st.peek();
        //     st.push(i);
        // }
        // int maxi = 0;
        // for(int i=0;i<n;i++){
        //     maxi = Math.max(maxi,heights[i]*(nse[i]-pse[i]-1));
        // }
        // return maxi;
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack();
        for(int i=0;i<=n;i++){
            int height = (i==n)?0:heights[i];
            while(!st.isEmpty() && height<heights[st.peek()]){
                int nse = i;
                int top = st.pop();
                int width = st.isEmpty()?nse:nse-st.peek()-1;
                maxArea = Math.max(maxArea,heights[top]*width);
            }
            st.push(i);
        }
        return maxArea;
    }
}