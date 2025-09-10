class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int index=0;
        while( index<n && s.charAt(index)==' '){
            index++;
        }
        if(index==n) return 0;
        boolean isNegative = false;
        if(s.charAt(index)=='-'){
            isNegative=true;
            index++;
        }
        int ans=0;
        while(index<n){
            if(isDigit(s.charAt(index))){
              int digit = s.charAt(index)-'0';
              if(ans>(Integer.MAX_VALUE)/10 || (ans==(Integer.MAX_VALUE/10) && digit>7)){
                return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
              }
              ans =   (ans)*10+digit;
              index++;
            }else{
                break;
            }
        }
        return isNegative? -ans:ans;
    }
    static boolean isDigit(Character ch){
        return ch>='0' && ch<='9';
    }
}