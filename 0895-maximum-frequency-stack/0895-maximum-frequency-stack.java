class FreqStack {
    HashMap<Integer,Integer> freq;
    HashMap<Integer,Stack<Integer>> grp;
    int maxFreq;
    public FreqStack() {
        freq=  new HashMap<>();
        grp = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val,0)+1;
        freq.put(val,f);
        maxFreq = Math.max(f,maxFreq);
        if(!grp.containsKey(f)){
            grp.put(f,new Stack<>());
        }
        grp.get(f).push(val);
    }
    
    public int pop() {
        int val  = grp.get(maxFreq).pop();
        freq.put(val,freq.get(val)-1);
        if(grp.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */