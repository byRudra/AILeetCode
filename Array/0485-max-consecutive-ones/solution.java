class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int curCount = 0;
        for(int num : nums){
            if(num == 0){
                curCount = 0;
                continue;
            }
            curCount++;
            maxCount = Math.max(curCount, maxCount);
        }
        return maxCount;
    }
}