class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> needing = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int needingVal = target - nums[i];
            if (needing.containsKey(needingVal)) return new int[] {needing.get(needingVal), i};
            needing.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}