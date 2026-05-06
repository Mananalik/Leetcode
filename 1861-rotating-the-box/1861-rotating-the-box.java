class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        // STEP 1: Apply gravity (move stones to the right)
        for (int i = 0; i < m; i++) {
            int emptyPos = n - 1;

            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    emptyPos = j - 1;
                } 
                else if (box[i][j] == '#') {
                    if (j != emptyPos) {
                        box[i][emptyPos] = '#';
                        box[i][j] = '.';
                    }
                    emptyPos--;
                }
            }
        }

        // STEP 2: Rotate matrix 90° clockwise
        char[][] result = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = box[i][j];
            }
        }

        return result;
    }
}