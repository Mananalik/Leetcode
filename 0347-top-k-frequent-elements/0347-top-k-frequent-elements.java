class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int num: nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> mp.get(a)-mp.get(b));
        for(int num: mp.keySet()){
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int ans[] = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i] = pq.poll();
        }
        return ans;
    }
}