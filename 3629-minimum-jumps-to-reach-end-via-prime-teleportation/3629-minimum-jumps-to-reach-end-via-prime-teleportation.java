class Pair{
    int index;
    int steps;
    Pair(int index, int steps){
        this.index = index;
        this.steps = steps;
    }
}
class Solution {
    public int minJumps(int[] nums) {
        HashMap<Integer,List<Integer>> mp = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        int n = nums.length;
        if(n<=1) return 0;
        int visIndex[] = new int[n];
        Set<Integer> visPrime = new HashSet<>();
        for(int i=0;i<n;i++){
            List<Integer> factors = getPrime(nums[i]);
            for(int p: factors){
                if(!mp.containsKey(p)) mp.put(p,new ArrayList<>());
                mp.get(p).add(i);
            }
        }
        q.add(new Pair(0,0));
        visIndex[0] = 1;
        while(!q.isEmpty()){
            Pair  p = q.poll();
            int index = p.index;
            int steps = p.steps;
            if(index==n-1) return steps;
            if(index+1<n && visIndex[index+1]==0){
                visIndex[index+1] = 1;
                q.add(new Pair(index+1,steps+1));
            }
            if(index-1>=0 && visIndex[index-1]==0){
                visIndex[index-1] = 1;
                q.add(new Pair(index-1,steps+1));
            } 
            if(mp.containsKey(nums[index])){
                if(!visPrime.contains(nums[index])){
                    visPrime.add(nums[index]);
                    for(int it: mp.get(nums[index])){
                    if(visIndex[it]==0) {
                        visIndex[it] = 1;
                        q.add(new Pair(it,steps+1));
                    }
                }
                }
                
            }
        }
        return -1;
    }
    public List<Integer> getPrime(int num){
        List<Integer> result = new ArrayList<>();
        for(int i=2;i*i<=num;i++){
            if(num%i==0) result.add(i);
            while(num%i==0){
                num/=i;
            }
        }
        if(num>1) result.add(num);
        return result;
    }
}