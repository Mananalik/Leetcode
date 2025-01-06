class Solution {
    public void setZeroes(int[][] matrix) {  
    //     for(int i=0;i<matrix.length;i++){
    //         for(int j=0;j<matrix[0].length;j++){
    //             if(matrix[i][j]==0){
    //                 rowZero(matrix,i);
    //                 colZero(matrix,j);
    //             }
    //         }
    //     }
    //     for(int i=0;i<matrix.length;i++){
    //         for(int j=0;j<matrix[0].length;j++){
    //             if(matrix[i][j]==-1){
    //                 matrix[i][j]=0;
    //             }
            
    //         }
            
    //     }
    // }
    // static void rowZero(int[][] matrix,int x) {
    //     int y = 0;
    //     while (y != matrix[0].length) {
    //         if(matrix[x][y]!=0) {
    //             matrix[x][y] = -1;
    //         }
    //         y++;
    //     }
    // }
    //     static void colZero(int[][] matrix,int y){
    //         int x=0;
    //         while(x!=matrix.length){
    //             if(matrix[x][y]!=0) {
    //                 matrix[x][y] = -1;
    //             }
    //             x++;
    //         }
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    if(j!=0){
                        matrix[0][j]=0;
                    }else{
                        col0 = 0;
                    }

                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]!=0){
                    if(matrix[i][0]==0 || matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }
        if(matrix[0][0]==0){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }

        }
        if(col0==0){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
}