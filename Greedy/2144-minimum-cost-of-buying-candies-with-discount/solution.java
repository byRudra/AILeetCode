class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int max = 0;
        for (int i = cost.length - 1; i >= 0; i -= 3) {
            max += cost[i];
            if (i - 1 >= 0) {
                max += cost[i - 1];
            }
        }
        return max;
    }

}