class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && k>0 && st.peek()-'0'>num.charAt(i)-'0'){
                st.pop();
                k=k-1;
            }
            st.push(num.charAt(i));
        }
        while(k>0){
            st.pop();
            k--;
        }
        if(st.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb = sb.reverse();
        int i=0;
        while(sb.length()!=0 && sb.charAt(i)=='0'){
            sb.deleteCharAt(i);
        }
        if(sb.length()==0){
            return "0";
        }
        return sb.toString();
    }
}