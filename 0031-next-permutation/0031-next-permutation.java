class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            reverseArr(nums,0,n-1);
            return;
        }
        for(int k=n-1;k>index;k--){
            if(nums[k]>nums[index]){
                int temp=nums[k];
                nums[k]=nums[index];
                nums[index]=temp;
                break;
            }
        }
        reverseArr(nums,index+1,n-1);
    }
    static void reverseArr(int [] arr ,int i , int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}