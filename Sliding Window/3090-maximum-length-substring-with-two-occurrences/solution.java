class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            map.put(current, map.getOrDefault(current, 0) + 1);
            while (map.get(current) > 2) {
                char remove = s.charAt(left++);
                map.put(remove, map.get(remove) - 1);
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}