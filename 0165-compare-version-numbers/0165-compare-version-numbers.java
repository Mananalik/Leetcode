class Solution {
    public int compareVersion(String version1, String version2) {
        int m = version1.length();
        int n = version2.length();
        int i=0;
        int j=0;
        while(i<m || j<n){
            int sum1 = 0;
            int sum2 = 0;
            while(i<m && version1.charAt(i)!='.'){
                sum1 = sum1*10 + version1.charAt(i)-'0';
                i++;
            }
            while(j<n && version2.charAt(j)!='.'){
                sum2 = sum2*10 + version2.charAt(j)-'0';
                j++;
            }
            if(sum1>sum2) return 1;
            else if(sum1<sum2) return -1;
            else{
                i++;
                j++;
            }
        }
        return 0;
    }
}