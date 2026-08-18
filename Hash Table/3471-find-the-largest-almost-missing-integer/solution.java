// class Solution {
//     public int largestInteger(int[] nums, int k) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int maxAns = -1;
//         for (int start = 0; start + k <= nums.length; start++) {
//             int curr = start;
//             HashSet<Integer> set = new HashSet<>(); 
//             while (curr < start + k) {
//                 set.add(nums[curr]);
//                 curr++;
//             }
//             for(int x : set){
//                 map.put(x, map.getOrDefault(x, 0) + 1);
//             }
//         }
//         for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//             if(entry.getValue() == 1){
//                 maxAns = Math.max(maxAns, entry.getKey());
//             }
//         }
//         return maxAns;
//     }
// }

// O(n) APPROACH

class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = -1;
        // only one window
         if (k == nums.length) {
            for (int num : map.keySet()) {
                ans = Math.max(ans, num);
            }
            return ans;
        }

        // Every element itself is a window
        if (k == 1) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    ans = Math.max(ans, entry.getKey());
                }
            }
            return ans;
        }

        if (map.get(nums[0]) == 1) {
            ans = Math.max(nums[0], ans);
        }
        if (map.get(nums[nums.length - 1]) == 1) {
            ans = Math.max(nums[nums.length - 1], ans);
        }
        return ans;
    }
}