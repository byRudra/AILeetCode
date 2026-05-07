class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0, leftSum = 0;
        for(int num : nums) totalSum += num;

        for(int i = 0; i < nums.length; i++){
            int rightSum = totalSum - leftSum - nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}