class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i=0; int j=0;
        List<Integer> list = computeLps(needle);
        while(i<m){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==n) return i-j;
            }
            else if(j>0){
                j = list.get(j-1);
            }
            else{
                i++;
            }
        }
        return -1;
    }
    public List<Integer> computeLps(String pattern){
        List<Integer> list = new ArrayList<>();
        int n = pattern.length();
        int i=1;
        int len=0;
        for(int j=0;j<n;j++){
            list.add(0);
        }
        while(i<n){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                list.set(i,len);
                i++;
                
            }else if(len>0){
                len = list.get(len-1);
            }else{
             list.set(i,0);
             i++;   
            }
        }
        return list;
    }
}