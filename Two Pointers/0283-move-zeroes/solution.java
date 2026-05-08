class Solution {
    public void moveZeroes(int[] nums) {
        int position = 0;
        for(int num : nums){
            if(num != 0) nums[position++] = num;
        }
        while(position < nums.length){
            nums[position++] = 0;
        }
    }
}