class Solution {
    public boolean isPowerOfTwo(int n) {
        return isPower(n,0);
    }
    static boolean isPower(int n , int digit){
        if(Math.pow(2,digit)>n) {
            return false;
        }
        if(Math.pow(2,digit)==n){
            return true;
        }

      return  isPower(n,digit+1);
    }
}