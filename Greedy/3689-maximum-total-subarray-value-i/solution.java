class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int minSubArray = Integer.MAX_VALUE;
        int maxSubArray = Integer.MIN_VALUE;
        for(int num : nums){
            minSubArray = Math.min(minSubArray, num);
            maxSubArray = Math.max(maxSubArray, num);
        }
        return 1L * k * (maxSubArray - minSubArray);
    }
}