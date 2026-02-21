class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int ans[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ans[i] = nums[((i + nums[i]) % nums.length + nums.length) % nums.length];
        }
        return ans;
    }
}