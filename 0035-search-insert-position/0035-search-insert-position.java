class Solution {
    public int searchInsert(int[] arr, int target) {
        int s = 0;
        int e = arr.length-1;
        int ans=arr.length;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(target==arr[mid]){
                ans=mid;
                return ans;
            }
            if(target<arr[mid]){
                ans=mid;
                e=mid-1;
            }
            if(target>arr[mid]){
                s=mid+1;
            }
        }
        return ans;
    }
}