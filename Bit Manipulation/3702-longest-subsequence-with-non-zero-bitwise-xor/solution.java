class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean contains = false;
        for(int num : nums){
            xor ^= num;
            if(num != 0){
                contains = true;
            }
        }
        if(xor != 0) return nums.length;
        if(contains)
            return nums.length - 1;
        return 0;
    }
}