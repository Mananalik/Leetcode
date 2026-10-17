class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        List<Integer> list  = new ArrayList<>();
        for(int num: nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        } 
        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
            if(entry.getValue()>1) list.add(entry.getKey());
        }
        return list;
    }
}