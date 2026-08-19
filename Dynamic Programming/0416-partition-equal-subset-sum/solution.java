class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum =0;
        for(int num : nums)
            totalSum += num;
        if(totalSum % 2 != 0) return false;
        int target = totalSum/2;
        for(int num : nums)
            if(target == num) return true;
        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][target + 1];
        dp[0][0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= target; j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i][j] || dp[i-1][j - nums[i-1]];
                }
            }
        }
        return dp[n][target];
        
    }
}