class Solution {
    public boolean isAnagram(String s, String t) {
        // HashMap<Character,Integer> mp = new HashMap<>();
        // int n = s.length();
        // int m = t.length();
        // int count = 0;
        // if(m!=n){
        //     return false;
        // }
        // for(int i=0;i<n;i++){
        //     if(!mp.containsKey(s.charAt(i))){
        //         mp.put(s.charAt(i),1);
        //     }else{
        //         mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     if(mp.containsKey(t.charAt(i))){
        //         mp.put(t.charAt(i),mp.get(t.charAt(i))-1);
        //     }
        // }
        // for(Map.Entry<Character,Integer> entry:mp.entrySet()){
        //     if(entry.getValue()!=0){
        //         count++;
        //     }
        // }
        // return count==0?true:false;

        //2nd method
        if(s.length()!=t.length()) return false;
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++) freq[s.charAt(i)-'a']++;
        for(int j=0;j<t.length();j++) if (--freq[t.charAt(j)-'a']<0) return false;
        return true;
    }
}