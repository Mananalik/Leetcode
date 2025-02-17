class Pair {
    String first;
    int second;
    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(beginWord , 1));
      Set<String> st = new HashSet<String>();
      int n = wordList.size();
      for(int i=0;i<n;i++){
        st.add(wordList.get(i));
      }
      st.remove(beginWord);
      while(!q.isEmpty()){
        String word = q.peek().first;
        int level = q.peek().second;
        q.remove();
        if(word.equals(endWord)){
            return level;
        }
        for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char[] replaced = word.toCharArray();
                replaced[i] = ch;
                String replacedWord = new String(replaced);
                if(st.contains(replacedWord)){
                    st.remove(replacedWord);
                    q.add(new Pair(replacedWord, level+1));
                }
            }
        }
      }
        return 0;
     }
}