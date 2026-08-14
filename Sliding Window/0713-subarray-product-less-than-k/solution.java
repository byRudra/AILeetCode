class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int count = 0;
        int start = 0;
        int currProd = 1;
        for (int end = 0; end < nums.length; end++) {
            currProd *= nums[end];
            while (currProd >= k) {
                currProd /= nums[start++];
            }
            count += end - start + 1;
        }
        return count;
    }
}