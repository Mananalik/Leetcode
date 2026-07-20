class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        Map<Character,Integer> mp = new HashMap<>();
        for( Character ch: t.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int l = 0;
        int r = 0;
        int cnt = 0;
        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        HashMap<Character,Integer> mp1 = new HashMap<>();
        while(r<n){
            char chr = s.charAt(r);
            mp1.put(chr,mp1.getOrDefault(chr,0)+1);
            if(mp.containsKey(chr) && mp1.get(chr).equals(mp.get(chr))){
                cnt++;
            }
            while(cnt==mp.size()){
                if(r-l+1<minLen){
                    minLen = r-l+1;
                    startIndex=l;
                }
                char chl = s.charAt(l);
                mp1.put(chl,mp1.get(chl)-1);
                if(mp.containsKey(chl) && mp1.get(chl)<mp.get(chl)){
                    cnt--;
                }
                l++;
            }
            r++;
        }
        return startIndex==-1? "": s.substring(startIndex,startIndex+minLen);
    }
}
