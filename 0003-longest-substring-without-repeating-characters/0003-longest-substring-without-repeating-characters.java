class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Optimized O(N)
        int l=0;
        int r=0;
        int maxi=0;
        int n = s.length();
        int hash[] = new int[256];
        Arrays.fill(hash,-1);
        while(r<n){
            if(hash[s.charAt(r)]!=-1){
                if(hash[s.charAt(r)]>=l){
                    l = hash[s.charAt(r)]+1;
                }
            }
            int len = r-l+1;
            maxi = Math.max(len,maxi);
            hash[s.charAt(r)]=r;
            r++;
        }
        return maxi;
        // Brute force



        // int n = s.length();
        // int maxLen = 0;
        // for(int i=0;i<n;i++){
        //     int hash[] = new int[256];
        //     for(int j=i;j<n;j++){
        //         if(hash[s.charAt(j)]==1){
        //             break;
        //         }
        //         int len = j-i+1;
        //         maxLen = Math.max(maxLen,len);
        //         hash[s.charAt(j)]=1;
        //     }

        // }
        // return maxLen;
    }
}