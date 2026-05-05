class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String str = tokens[i];

            if(!str.equals("+") && !str.equals("-")  && !str.equals("*")  && !str.equals("/") ){
                int num = Integer.parseInt(str);
                st.push(num);
            }else{
                if(str.equals("+")){
                    int a = st.pop();
                    int b = st.pop();
                    int ans = a+b;
                    st.push(ans);
                }
                else if(str.equals("-")){
                    int a = st.pop();
                    int b = st.pop();
                    int ans = b-a;
                    st.push(ans);
                }
                else if(str.equals("*")){
                    int a = st.pop();
                    int b = st.pop();
                    int ans = b*a;
                    st.push(ans);
                }
                else if(str.equals("/")){
                    int a = st.pop();
                    int b = st.pop();
                    int ans = b/a;
                    st.push(ans);
                }
            }
        }
        return st.pop();
    }
}