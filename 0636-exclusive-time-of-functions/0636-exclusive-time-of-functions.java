class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prevTime = 0;
        Stack<Integer> st = new Stack<>();
        int result[] = new int[n];
        for(String log : logs){
            String[] str = log.split(":");
            int id= Integer.parseInt(str[0]);
            String type = str[1];
            int time = Integer.parseInt(str[2]);
            if(type.equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += (time-prevTime);
                    st.push(id);
                    prevTime = time;
                }else{
                    st.push(id);
                    prevTime = time;
                }
                
            }else{
                result[st.peek()]+=(time-prevTime+1);
                st.pop();
                prevTime = time+1;
            }
        }
        return result;
    }
}