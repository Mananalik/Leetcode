import java.util.Arrays;
class Solution {
    public void reverseString(char[] s) {
       int a = 0;
       int e = s.length-1;
       System.out.println(Arrays.toString(reverse(s , a, e)));
    }
    static char[] reverse(char [] s ,int x ,int e){
       
     if(x>=e){
            return s;
        }
        char temp;
        temp = s[x];
        s[x] = s[e];
        s[e] = temp;
        return reverse(s , x+1,e-1);
    }
    }
