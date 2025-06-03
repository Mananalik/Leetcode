class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int index2 = n/2;
        int index1 = index2-1;
        int cnt = 0;
        int i = 0;
        int j=0;
        int el1 = -1;
        int el2 = -1;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                if(cnt==index1) el1 = nums1[i];
                if(cnt==index2) el2 = nums1[i];
                cnt++;
                i++;
            }else{
                if(cnt==index1) el1 = nums2[j];
                if(cnt==index2) el2 = nums2[j];
                cnt++;
                j++;
            }
        }
        while(i<n1){
            if(cnt==index1) el1 = nums1[i];
            if(cnt==index2) el2 = nums1[i];
            cnt++;
            i++;
        }
        while(j<n2){
            if(cnt==index1) el1 = nums2[j];
            if(cnt==index2) el2 = nums2[j];
            cnt++;
            j++;
        }
        if(n%2!=0){
            return (double) el2;
        }
        double x = (double) (el1+el2);
        return (double) x/2;
    }
}