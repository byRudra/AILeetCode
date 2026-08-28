class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int longest = 0;
        for (int num : set) {
            if(!set.contains(num - 1)){
                int current = num;
                int currLength = 1;
                while(set.contains(current + 1)){
                    current++;
                    currLength++;
                }
                longest = Math.max(longest, currLength);
            }
        }
        return longest;
    }
}