class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] str = path.split("/");
        for(String s: str){
            if(s.equals("")|| s.equals(".")){
                continue;
            }
            if(s.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(st.isEmpty()){
            sb.append("/");
            return sb.toString();
        }
        for(String s: st){
            sb.append("/").append(s);
        }
        return sb.toString();
    }
}