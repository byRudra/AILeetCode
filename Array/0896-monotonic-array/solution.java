class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isAsc = true;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){ 
                isAsc = false;
                break;
            }
        }
        if (isAsc == true) return true; 
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){ 
                return false;
            }
        }
        return true;
    }
}