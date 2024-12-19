class Solution {
    public int[] rearrangeArray(int[] nums) {
        // ArrayList<Integer> arr  = new ArrayList<>(Arrays.asList(nums));
        int arr[] = new int [nums.length];
        int pos = 0;
        int neg = 1;
        for(int i = 0;i<nums.length;i++){
             if(nums[i]<0){
                arr[neg]=nums[i];
                neg+=2;
             }
             else if(nums[i]>=0) {
                 arr[pos] = nums[i];
                 pos+=2;
             }
        }
        return arr;
    }
}