class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return Math.abs(atMost(nums, goal) - atMost(nums, goal - 1));
    }
    private static int atMost(int nums[], int goal){
        if (goal < 0) return 0;
        int count = 0;
        int start = 0;
        int currSum = 0;
        for(int end = 0; end < nums.length; end++){
            currSum += nums[end];
            while(currSum > goal){
                currSum -= nums[start++];
            }
            count += end - start + 1;
        }
        return count;
    }
}