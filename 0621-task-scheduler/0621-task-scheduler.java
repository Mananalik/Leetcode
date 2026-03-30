class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for(char c : tasks){
            freq[c-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int f : freq){
            if(f>0) pq.add(f);
        }
        int time = 0;
        while(!pq.isEmpty()){
            int cycle = n+1;
            List<Integer> temp = new ArrayList<>();
            while(cycle>0 && !pq.isEmpty()){
                int curr = pq.poll();
                if(curr-1>0){
                    temp.add(curr-1);
                }
                time++;
                cycle--;
            }
            for(int i: temp){
                pq.add(i);
            }
            if(pq.isEmpty()) break;
            time+=cycle;
        }
        return time;
    }
}
