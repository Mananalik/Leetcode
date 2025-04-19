class Solution:
    def longestPrefix(self, str: str) -> str:
        n=len(str)
        res =""
        for i  in range(n-1,-1,-1):
            s = str[:i]
            if str.endswith(s):
                res+=s
                break
        return res