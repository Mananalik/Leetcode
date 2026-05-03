class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        StringBuilder sb = new StringBuilder (s);
        sb.append(s);
        int ptr1 = 0;
        int ptr2 = s.length();
        while(ptr1<s.length()){
            if(goal.equals(sb.substring(ptr1,ptr2))) return true;
            ptr1++;
            ptr2++;
        }
        return false;
    }
}