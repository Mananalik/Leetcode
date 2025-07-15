class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class StockSpanner {
    Stack<Pair> st ;
    int index = -1;
    public StockSpanner() {
        st = new Stack<>();
        index = -1;
    }
    
    public int next(int price) {
        index = index+1;
        while(!st.isEmpty() && st.peek().first<=price){
            st.pop();
        }
        int ans = index-(st.isEmpty()?-1:st.peek().second);
        st.push(new Pair(price,index));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */