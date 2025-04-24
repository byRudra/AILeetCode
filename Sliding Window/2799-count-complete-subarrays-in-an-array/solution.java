class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> distinct = new HashSet<>();

        for (int num : nums) {
            distinct.add(num);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> seen = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                seen.add(nums[j]);
                if (seen.size() == distinct.size()) {
                    count += nums.length - j;
                    break;
                }
            }
        }
        return count;
    }
}