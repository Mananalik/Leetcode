class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if(visited.contains("0000")) return -1;
        visited.add("0000");
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int moves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String temp = q.poll();
                if(temp.equals(target)) return moves;
                for(String str : children(temp)){
                    if(!visited.contains(str)){
                        q.add(str);
                        visited.add(str);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    public List<String> children(String temp){
        List<String> res = new ArrayList<>();
        for(int i=0;i<4;i++){
            char arr[] = temp.toCharArray();
            arr[i] = (char)(((arr[i]-'0'+1)%10)+'0');
            res.add(new String(arr));

            arr = temp.toCharArray();
            arr[i] = (char)(((arr[i]-'0'+9)%10)+'0');
            res.add(new String(arr));

        }
        return res;
    }
}