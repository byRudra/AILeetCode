class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(nums[i] == target){
                minDistance = Math.min(minDistance, Math.abs(i-start));
            }
        }
        return minDistance;
    }
}