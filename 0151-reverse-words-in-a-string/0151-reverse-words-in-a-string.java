class Solution {
    public String reverseWords(String s) {
        // Brute Force not working for multiple spaces and spaces at starting and end
        // Stack<String> st = new Stack<>();
        // String str = "";
        // s+=" ";
        // int n = s.length();
        // for(int i=0;i<n;i++){
        //     if(s.charAt(i)==' '){
        //         st.add(str);
        //         str="";
        //     }else{
        //         str+=s.charAt(i);
        //     }
        // }
        // String ans = "";
        // while(st.size()!=1){
        //     ans+=st.peek();
        //     ans+=" ";
        //     st.pop();
        // }
        // ans+=st.peek();
        // return ans;


        // 2nd Method not works for the same reaon


        // int left = 0;
        // int right = s.length()-1;
        // String ans="";
        // String temp="";
        // while(left<=right){
        //     if(s.charAt(left)!=' '){
        //         temp+=s.charAt(left);
        //     }else if(s.charAt(left)==' '){
        //         if(!ans.equals("")){
        //             ans=temp+" "+ans;
        //         }else{
        //             ans=temp;
        //         }
        //         temp="";
        //     }
        //     left++;
        // }
        // if(temp!=""){
        //     if(ans!=""){
        //         ans = temp+" "+ans;
        //     }else{
        //         ans=temp;
        //     }
        // }
        // return ans;

        // 3rd Method

        String[] str = s.trim().split("\\s+");
        int n = str.length;
        String ans="";
        for(int i=n-1;i>0;i--){
            ans+=str[i];
            ans+=" ";
        }
        ans+=str[0];
        return ans;
    }
}