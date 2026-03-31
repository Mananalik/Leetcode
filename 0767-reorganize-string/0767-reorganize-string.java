class Pair{
    
}
class Solution {
    public String reorganizeString(String s) {
        int freq[] = new int[26];
        for( char c: s.toCharArray()){
            freq[c-'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<26;i++){
            if(freq[i]>0) pq.add(new int[]{i,freq[i]});
        }
        int [] prev = null;
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            sb.append((char)(curr[0]+'a'));
            curr[1]--;
            if(prev!=null && prev[1]>0){
                pq.add(prev);
            }
            prev=curr;
        }
        if(sb.length()!=s.length()) return "";
        return sb.toString();
    }
}