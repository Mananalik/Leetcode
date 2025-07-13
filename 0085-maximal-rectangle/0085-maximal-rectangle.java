class Solution {
    public int maximalRectangle(char[][] matrix) {
      int m = matrix.length;
      int n = matrix[0].length;
      int maxArea=0;
      int psum[] = new int[n];
      for(int j=0;j<m;j++){
        int sum = 0;
        for(int i=0;i<n;i++){
           if (matrix[j][i] == '1') {
                    psum[i] += 1;
                } else {
                    psum[i] = 0;
                }

        }
         maxArea = Math.max(maxArea, func(psum));
      }
      
      return maxArea;  
    }
    static int func(int[]arr){
        int n = arr.length;
        Stack<Integer> st=  new Stack<>();
        int area = 0;
        for(int i=0;i<=n;i++){
            int height = (i==n)?0:arr[i];
            while(!st.isEmpty() && arr[st.peek()]>height){
                int top = st.pop();
                int elem = arr[top];
                int width = st.isEmpty()?i:i-st.peek()-1;
                area = Math.max(area,elem*width);
            }
            st.push(i);
        }
        return area;

    }
}