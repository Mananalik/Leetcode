class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        for(String str: strs){
            int count[] = new int[26];
            for(char ch: str.toCharArray()){
                count[ch-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int num: count){
                sb.append("#").append(num);
            }
            String key = sb.toString();
            mp.putIfAbsent(key, new ArrayList<>());
            mp.get(key).add(str);
        }
        return new ArrayList<>(mp.values());
    }
}