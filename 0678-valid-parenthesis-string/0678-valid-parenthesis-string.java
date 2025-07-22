class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.add(i);
            }
            else if(s.charAt(i)=='*'){
                star.add(i);
            }else{
                if(!st.isEmpty()){
                    st.pop();
                }
                else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }    
        }
        while(!st.isEmpty() && !star.isEmpty()){
            if(st.pop()>star.pop()){
                return false;
            }
        }
        return st.isEmpty();
    }
}