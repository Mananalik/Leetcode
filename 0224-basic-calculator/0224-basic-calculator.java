class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        int sign = 1;
        int result = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10+ (ch-'0');
            }
            else if(ch=='+'){
                result = result+sign*num;
                sign = 1;
                num = 0;
            }
            else if(ch=='-'){
                result = result+sign*num;
                sign = -1;
                num = 0;
            }
            else if (ch=='('){
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
            }
            else if (ch==')'){
                result = result+sign*num;
                num = 0;
                result=result*st.pop();
                result = result+st.pop();
                sign = 1;
            }
        }
        if(num!=0){
            result+=sign*num;
        }
        return result;
    }
}