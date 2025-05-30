class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<weights.length;i++){
            max = Math.max(weights[i],max);
            sum+=weights[i];
        }
        int s = max;
        int e = sum;
        while(s<=e){
            int mid = s+(e-s)/2;
            int daysReq = func(weights, mid);
            if(daysReq<=days){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return s;
    }
    static int func(int [] arr, int cap){
        int day = 1;
        int load = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+load>cap){
                day = day+1;
                load=arr[i];
            }else{
                load+=arr[i];
            }
        }
        return day;
    }
}