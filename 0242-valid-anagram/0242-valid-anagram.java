class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int [] freq = new int[26];
        for(Character ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        for(Character ch : t.toCharArray()){
            freq[ch-'a']--;
            if(freq[ch-'a']<0) return false;
        }
        return true;
    }
}