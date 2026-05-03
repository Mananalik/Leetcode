class Solution {
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int arr[] = new int[len];
        int ptr1 = 0;
        int ptr2 = n;
        for(int i=0;i<len;i+=2){
            arr[i] = nums[ptr1];
            arr[i+1] = nums[ptr2];
            ptr1++;
            ptr2++;
        }
        return arr;
    }
}