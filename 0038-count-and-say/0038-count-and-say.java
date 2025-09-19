class Solution {
    public String countAndSay(int n) {
        String str="1";
        for(int i=1;i<n;i++){
            str=func(str);
        }
        return str;
    }
    private String func(String str){
        int n = str.length();
        StringBuilder sb = new StringBuilder("");
        int count = 1;
        for(int i=1;i<=n;i++){
            if(i<n && str.charAt(i)==str.charAt(i-1)){
                count++;
            }else{
                sb.append(count);
                sb.append(str.charAt(i-1));
                count=1;
            }
        }
        return sb.toString();
    }
}