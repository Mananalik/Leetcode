class Solution {
    public int majorityElement(int[] nums) {
//     quickSort(nums,0,nums.length-1);    
//     int count=0;
//     int j=0;
//     for(int i=0;i<nums.length;i++){
//         while(j<nums.length) {
//             if (nums[i] == nums[j]) {
//                 count++;
//                 j++;
//             } else {
//                 break;
//             }
//         }
//             if(count>nums.length/2){
//                 return nums[i];
//             }


//     }
//     return -1;
// }
//    static void quickSort(int[]nums,int low,int high){
//         if(low>=high){
//             return;
//         }
//         int s=low;
//         int e=high;
//         int m=s+(e-s)/2;
//         int pivot=nums[m];
//         while(s<=e){
//             // also a reason why if its already sorted it will not swap
//             while(nums[s]<pivot){
//                 s++;
//             }
//             while(nums[e]>pivot){
//                 e--;
//             }
//             if(s<=e){
//                 int temp=nums[s];
//                 nums[s]=nums[e];
//                 nums[e]=temp;
//                 s++;
//                 e--;
//             }
//         }
//         // now my pivot is correct position , solve two part of the arrays
//         quickSort(nums,low,e);
//         quickSort(nums,s,high);
           
           int el = 0;
           int count=0;
           for(int i=0;i<nums.length;i++){
               if(count==0){
                count=1;
                el=nums[i];
               }else if(el==nums[i]){
                count++;
               }
               else{
                count--;
               }
           }
           int count1=0;
           for(int i=0;i<nums.length;i++){
               if(nums[i]==el){
                count1++;
               }
           }
           if(count1>nums.length/2){
            return el;
           }
           return -1;
    }
}