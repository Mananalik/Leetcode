class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        int start=0;
        int maxLen=1;
        for(int i=0;i<n;i++) dp[i][i]=1;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
                if(maxLen==1){
                start=i;
                maxLen=2;
            }
            }
            
        }
        for(int len=3;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j = len+i-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    dp[i][j]=1;
                    if(len>maxLen){
                        start=i;
                        maxLen=len;
                    }
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}