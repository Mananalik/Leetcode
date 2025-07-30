class Solution {
    public List<List<String>> solveNQueens(int n) {
     boolean mat[][] = new boolean[n][n];
     
     List<List<String>> ans = new ArrayList<>();
    func(mat,0,ans);
     return ans;
    }
    static void func(boolean mat[][] , int row,  List<List<String>> ans){
        if(row==mat.length){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<mat.length;i++){
                String s = "";
                for(int j=0;j<mat.length;j++){
                    if(mat[i][j]) s+="Q";
                    else s+=".";
                }
                temp.add(s);
            }
            ans.add(temp);

            return;
        }
        for(int col=0;col<mat.length;col++){
            if(isSafe(mat,row,col)){
                mat[row][col] = true;
                func(mat,row+1,ans);
                mat[row][col] = false;
            }
        }
        return;
    }
    static boolean isSafe(boolean mat[][] , int row , int col){
        for(int i=0;i<row;i++){
            if(mat[i][col]){
                return false;
            }
        }
        int minLeft = Math.min(row,col);
        for(int i=1;i<=minLeft;i++){
            if(mat[row-i][col-i]){
                return false;
            }
        }
        int minRight = Math.min(row,mat.length-col-1);
        for(int i=1;i<=minRight;i++){
            if(mat[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

}