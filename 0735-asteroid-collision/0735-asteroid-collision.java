class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        for(int i=0;i<n;i++){
            if(asteroids[i]>0) st.push(asteroids[i]);
            else{
            while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(asteroids[i])){
                st.pop();
            }
            if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i])){
                st.pop();
            }
           else if(st.isEmpty() || st.peek()<0){
                st.push(asteroids[i]);
            }
            }
        }
        int k = st.size();
        int arr[] = new int[k];
        if(k==0){
            return arr;
        }
        for(int i=k-1;i>=0;i--){
            arr[i] = st.pop();
        }
        return arr;
    }
}