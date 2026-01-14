class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumFrequency = new HashMap<>();
        prefixSumFrequency.put(0, 1);  // base case

        int prefixSum = 0;
        int subarrayCount = 0;

        for (int index = 0; index < nums.length; index++) {
            prefixSum += nums[index];

            int requiredPrefix = prefixSum - k;

            if (prefixSumFrequency.containsKey(requiredPrefix)) {
                subarrayCount += prefixSumFrequency.get(requiredPrefix);
            }

            prefixSumFrequency.put(
                prefixSum,
                prefixSumFrequency.getOrDefault(prefixSum, 0) + 1
            );
        }

        return subarrayCount;
    }
}