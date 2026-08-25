class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int multiplier = 1;
        while (true) {
            if (!set.contains(k * multiplier))
                return multiplier * k;
            multiplier++;
        }
    }
}
