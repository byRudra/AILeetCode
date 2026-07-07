class Solution {
    public int helpRob(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(helpRob(nums, 1, n - 1), helpRob(nums, 0, n - 2));
    }
}