class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int result[][] = new int[rows * cols][2];
        int indx = 0;
        result[indx][0] = rStart;
        result[indx][1] = cStart;

        indx++;

        int r = rStart, c = cStart;
        // east south west north
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        int d = 0;
        int step = 1;

        while (indx < rows * cols) {
            for (int i = 0; i < 2; i++) {
                for (int s = 0; s < step; s++) {
                    r += dr[d];
                    c += dc[d];
                    if ((r >= 0 && r < rows) && (c >= 0 && c < cols)) {
                        result[indx][0] = r;
                        result[indx][1] = c;

                        indx++;

                    }
                    if (indx == rows * cols)
                        return result;
                }
                d = (d + 1) % 4;
            }
            step++;
        }
        return result;
    }
}