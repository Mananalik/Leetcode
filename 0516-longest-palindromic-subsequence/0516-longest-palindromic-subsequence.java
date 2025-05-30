class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int prev[] = new int[n+1];
        int curr[] = new int[n+1];
        for(int i=0;i<=n;i++){
            prev[i]= 0;
        } 
        for(int i = 1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    curr[j] = 1+prev[j-1];
                }else{
                    curr[j] = Math.max(prev[j],curr[j-1]);
                }
            }
            prev = curr.clone();
        }
        return prev[n];
    }
}