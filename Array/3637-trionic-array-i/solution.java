class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4)
            return false;
        int i = 0;

        // Increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }

        if(i == 0 || i == n - 1) return false;
        
        // Decreasing
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }

        if(i == 0 || i == n - 1) return false;
        
        // Increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        
        return i == n-1;
    }
}