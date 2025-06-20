class Solution {
    public int trap(int[] arr) {
       int n = arr.length;
       int lmax = 0;
       int rmax = 0;
       int l = 0;
       int r = n-1;
       int total = 0;
       while(l<r){
        if(arr[l]<=arr[r]){
            if(arr[l]<lmax){
                total+= lmax-arr[l];
            }else{
                lmax = arr[l];
            }
            l = l+1;
        }else{
            if(arr[r]<rmax){
                total+= rmax-arr[r];
            }else{
                rmax = arr[r];
            }
            r = r-1;
        }
       }
       return total;
    }
}