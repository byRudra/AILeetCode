// O (n²)

// class Solution {
//     public int[] findMissingAndRepeatedValues(int[][] grid) {
//         int[] result = new int[2];
//         HashSet<Integer> seenNumbers = new HashSet<>();
//         int n = grid.length;
//         for (int row = 0; row < n; row++) {
//             for (int col = 0; col < n; col++) {
//                 int value = grid[row][col];
//                 if (seenNumbers.contains(value)) {
//                     result[0] = value;
//                 } else {
//                     seenNumbers.add(value);
//                 }
//             }
//         }
//         for (int index = 1; index <= n * n; index++) {
//             if (!seenNumbers.contains(index)) {
//                 result[1] = index;
//                 break;
//             }
//         }

//         return result;
//     }
// }

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long N = n * n;

        long expectedSum = N * (N + 1) / 2;
        long expectedSumSquared = N * (N + 1) * (2 * N + 1) / 6;

        long actualSum = 0;
        long actualSumSquared = 0;

        for (int[] row : grid) {
            for (int col : row) {
                actualSum += col;
                actualSumSquared += col * col;
            }
        }

        long diff =  actualSum - expectedSum;
        long diffSquare = actualSumSquared -  expectedSumSquared;

        long sum = diffSquare / diff;

        int repeatingNumber = (int) ((sum + diff) / 2);
        int missingNumber = (int) (repeatingNumber - diff);

        return new int[] { repeatingNumber, missingNumber };

    }
}
