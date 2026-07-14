class Solution {
    public int numberOfSubstrings(String s) {
       int n = s.length();
       int l = 0;
       int r = 0;
       int cnt = 0;
       int freq[] = new int[3];
       while(r<n){
        freq[s.charAt(r)-'a']++;
        while(freq[0]>=1 && freq[1]>=1 && freq[2]>=1){
            cnt+=(n-r);
            freq[s.charAt(l)-'a']--;
            l++;
        }
        r++;
       } 
       return cnt;
    }
}