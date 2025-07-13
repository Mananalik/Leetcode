class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque <Integer> q = new ArrayDeque<>();
        int arr[] = new int[n-k+1];
        int j=0;
        for(int i=0;i<n;i++){
            if(!q.isEmpty() && q.peek()==i-k){
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.offerLast(i);
            if(i>=k-1) arr[j++] = nums[q.peekFirst()];
        }
        return arr;
    }
}