class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int arr[] = new int [26];
        for(int i=0;i<order.length();i++){
            arr[order.charAt(i)-'a'] = i;
        }
        for(int i=0;i<words.length-1;i++){
            String str1 = words[i];
            String str2 = words[i+1];
            int len = Math.min(str1.length(),str2.length());
            boolean isPassed = false;
            for(int j=0;j<len;j++){
                if(arr[str1.charAt(j)-'a']<arr[str2.charAt(j)-'a']){
                    isPassed = true;
                    break;
                }
                if(arr[str1.charAt(j)-'a']>arr[str2.charAt(j)-'a']) return false;
            }
            if (!isPassed){
                if(str1.length()>str2.length()) return false;
            }
        }
        return true;
    }
}