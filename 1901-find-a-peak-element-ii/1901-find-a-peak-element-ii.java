class Solution {
    public int[] findPeakGrid(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int s = 0;
    int e = n-1;
    while(s<=e){
        int mid = s+(e-s)/2;
        int maxRow = func(mat,m,mid);
        int left = mid-1>=0?mat[maxRow][mid-1]:-1;
        int right = mid+1<n?mat[maxRow][mid+1]:-1;
        if(mat[maxRow][mid]>left && mat[maxRow][mid]>right){
            return new int[] {maxRow,mid};
        }
        if(mat[maxRow][mid]<left){
            e = mid-1;
        }else{
            s=mid+1;
        }
    }
    return new int[] {-1,-1};
    }
    static int func(int[][] mat , int m , int col){
        int index = -1;
        int maxel = -1;
        for(int i = 0;i<m;i++){
            if(mat[i][col]>maxel){
                maxel = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}