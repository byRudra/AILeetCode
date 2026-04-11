class Solution {
    public int minimumDistance(int[] nums) {
        if (nums.length < 3)
            return -1;
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (List<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i + 2 < list.size(); i++) {
                    int current = 2 * (list.get(i + 2) - list.get(i));
                    ans = Math.min(current, ans);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}