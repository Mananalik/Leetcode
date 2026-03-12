class TimeMap {
    HashMap<String,List<Pair>> mp;
    class Pair{
        int time;
        String val;
        Pair(int t , String v){
            time = t;
            val = v;
        }
    }
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key,new ArrayList<>());
        mp.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key)){
            return "";
        }
        List<Pair> list= mp.get(key);
        int s = 0;
        int e = list.size()-1;
        String res = "";
        while(s<=e){
            int mid = s+(e-s)/2;
            if(list.get(mid).time<=timestamp){
                res = list.get(mid).val;
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return res;
    }
}
