class Solution {
    public int longestConsecutive(int[] nums) {
       int n = nums.length;
       if(n==0){
        return 0;
       }
       int longest=1;
       Set<Integer> set = new HashSet<>(); 
       for(int i=0;i<n;i++){
        set.add(nums[i]);
       }
       for(int j:set){
        if(!set.contains(j-1)){
            int count=1;
            int x = j;
            while(set.contains(j+1)){
                j=j+1;
                count++;

            }
            longest=Math.max(longest,count);
        }
       }
       return longest;
    }
}