class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int currentValue = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                currentValue = Math.min(currentValue, matrix[i][j]);
            }
            min.add(currentValue);
        }
        // column
        for (int i = 0; i < matrix[0].length; i++) {
            int currentValue = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                currentValue = Math.max(currentValue, matrix[j][i]);
            }
            max.add(currentValue);
        }
        min.retainAll(max);
        return min;
    }
}