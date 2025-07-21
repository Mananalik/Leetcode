class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length;
        int n = s.length;
        int cnts = 0;
        int cntg =0;
        while(cnts<n && cntg<m){
            if(g[cntg]<=s[cnts]){
                cntg++;
            }
            cnts++;
        }
        return cntg;
    }
}