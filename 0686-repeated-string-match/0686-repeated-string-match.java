class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder repeat = new StringBuilder(a);
        int count=1;
        while(repeat.length()<b.length()){
            repeat.append(a);
            count++;
        }
        if (kmpSearch(repeat.toString(),b)) return count;
        repeat.append(a);
        count++;
        if(kmpSearch(repeat.toString(),b)) return count;
        return -1;
    }
    public boolean kmpSearch(String text, String pattern){
        int n = text.length();
        int m = pattern.length();
        List<Integer> lps = computeLCS(pattern);
        int i=0;
        int j=0;
        while(i<n){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
                if(j==m) return true;
            }else if(j>0){
                j = lps.get(j-1);
            }else{
                i++;
            }
        }
        return false;
    }
    public List<Integer> computeLCS(String pattern){
        List<Integer> lps = new ArrayList<>();
        int n = pattern.length();
        for(int i=0;i<n;i++){
            lps.add(0);
        }
        int len=0; int i=1;
        while(i<n){
            if(pattern.charAt(i)==pattern.charAt(len)){
              len++;
              lps.set(i,len);
              i++;
            }
            else if(len>0){
                len = lps.get(len-1);
            }else{
                lps.set(i,0);
                i++;
            }
        }
        return lps;
    }
}