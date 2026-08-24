class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int curr = 0;
        int min = Integer.MAX_VALUE;

        for(; end < nums.length; end++){
            curr += nums[end];
            while(curr >= target){
                min = Math.min(end - start + 1, min);
                curr -= nums[start++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}