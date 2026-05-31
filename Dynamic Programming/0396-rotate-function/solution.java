class Solution {
    public int maxRotateFunction(int[] nums) {
         int n = nums.length;

        long sum = 0;
        long f = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }

        long max = f;
        for (int i = 1; i < n; i++) {
            f = f - (long) n * nums[n - i] + sum;
            max = Math.max(max, f);
        }
        return  (int) max;
    }
}