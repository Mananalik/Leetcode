class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
int a[]=new int[m+n];
        int i=0,j=0,k=0;
        while(i<m&&j<n)
        {
            if(nums1[i]<=nums2[j])
            {
                a[k++]=nums1[i++];
            }
            else{
                a[k++]=nums2[j++];
            }
        }
        while(i<m)
        {
            a[k++]=nums1[i++];
        }
        while(j<n)
        {
            a[k++]=nums2[j++];
        }
       for(int x=0;x<a.length;x++)
       {
        nums1[x]=a[x]; }
    }
}