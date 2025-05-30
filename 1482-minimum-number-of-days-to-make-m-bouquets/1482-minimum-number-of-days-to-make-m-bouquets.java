class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m*k;
        int n = bloomDay.length;
        if(val>n) return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            min = Math.min(bloomDay[i],min);
            max = Math.max(bloomDay[i],max);
        }
        int s=min;
        int e = max;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(func(bloomDay,mid,m,k)){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return s;
    }
    static boolean func(int [] arr, int mid, int m , int k){
        int cnt = 0;
        int noB = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                cnt++;
            }else{
                noB+=(cnt/k);
                cnt=0;
            }
        }
        noB+=(cnt/k);
        return noB>=m;
    }
}