class Solution {
    public int vowelConsonantScore(String s) {
        HashSet<Character> set = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
        s = s.toLowerCase();
        char ch[] = s.toCharArray();
        int vow = 0;
        int cons = 0;
        for(Character c : ch){
            if(Character.isLetter(c)){
                 if(set.contains(c)){
                vow++;
                }
                else{
                    cons++;
                }
            
            }
           
        }
        int score = 0;
        if(cons>0){
            score  =(int) Math.floor(vow/cons);
        }
        return score;
    }
}