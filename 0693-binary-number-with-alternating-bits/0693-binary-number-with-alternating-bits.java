class Solution {
    public boolean hasAlternatingBits(int n) {
        n = n^(n>>1);
        if ((n & (n+1))==0) return true;
        return false;
    }
}