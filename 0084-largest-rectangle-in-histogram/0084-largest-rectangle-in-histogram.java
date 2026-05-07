class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxi = 0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int index = st.pop();
                int height = heights[index];
                int width;
                if(st.isEmpty()){
                    width = i;
                }else{
                    width =  i - st.peek() -1;
                }
                maxi = Math.max(maxi, height*width);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int index = st.pop();
            int height = heights[index];
            int width;
            if(st.isEmpty()){
                    width = n;
                }else{
                    width =  n - st.peek() -1;
                }
            maxi = Math.max(maxi,height*width);
        }        
        return maxi;
    }
}