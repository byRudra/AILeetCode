class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;

        int left = 0;
        int right = column - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // finding max element row
            int maxRow = 0;
            for (int i = 0; i < row; i++) {
                if (mat[i][mid] > mat[maxRow][mid])
                    maxRow = i;
            }

            // checking adjecent values

            int leftValue = (mid - 1 >= 0) ? mat[maxRow][mid - 1] : -1;
            int rightValue = (mid + 1 < column) ? mat[maxRow][mid + 1] : -1;

            int currentValue = mat[maxRow][mid];
            // check Peak Value

            if(leftValue < currentValue && rightValue < currentValue) return new int[]{maxRow, mid};

            // checking the greater way to go

            if(leftValue > currentValue){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}