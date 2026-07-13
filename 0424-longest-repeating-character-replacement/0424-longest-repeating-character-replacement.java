class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int maxFreq = 0;
        while(r<s.length()){
            freq[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(r)-'A']);
            if((r-l+1)-maxFreq>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1)-maxFreq<=k){
                maxLen = Math.max((r-l+1),maxLen);
            }
            r++;
        }
        return maxLen;
    }
}
