class Solution {
    public int numSubarraysWithSum(int[] arr, int goal) {
        return atMost(arr,goal)-atMost(arr,goal-1);
    }
    public int atMost(int arr[], int goal){
        if (goal < 0) return 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        int cnt = 0;
        int n = arr.length;
        while(r<n){
            sum+=arr[r];
            while(sum>goal){
                sum-=arr[l];
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
}