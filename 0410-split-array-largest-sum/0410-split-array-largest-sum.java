class Solution {
    public int splitArray(int[] nums, int m) {
        if(nums.length<m){
            return -1;
        }
         int max = Integer.MIN_VALUE;
         int sum = 0;
         for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
            sum+=nums[i];
         }
         int s = max;
         int e=  sum;
         while(s<=e){
            int mid = s+(e-s)/2;
            int cnt = func(nums,mid);
            if(cnt>m){
                s=mid+1;
            }else{
                e=mid-1;
            }
         }
         return s;
    }
    static int func(int[] arr , int len){
        int cnt =1 ;
        int sum = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(sum+arr[i]<=len){
                sum+=arr[i];
            }else{
                cnt++;
                sum=arr[i];
            }
        }
        return cnt;
    }
    }
