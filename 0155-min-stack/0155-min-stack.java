class MinStack {
    Stack<Long> st;
    Long min;
    public MinStack() {
        st = new Stack<Long>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        Long val1 = Long.valueOf(val);
        if(st.isEmpty()){
            st.push(val1);
             min = val1;
        }else{
            if(val1<min){
                Long newmin = 2*val1-min;
                st.push(newmin);
                min = val1;
            }else{
                st.push(val1);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        Long x = st.peek();
        if(x<min){
            min = 2*min-x;
        }
        st.pop();
    }
    
    public int top() {
        Long x = st.peek();
        if(x>min) return x.intValue();
        return min.intValue();
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */