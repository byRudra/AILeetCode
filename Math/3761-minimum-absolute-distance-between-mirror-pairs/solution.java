class Solution {
    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + (num % 10);
            num /= 10;
        }
        return rev;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            int reversed = reverse(nums[i]);

            if(map.containsKey(nums[i])){
                minDistance = Math.min(minDistance, i - map.get(nums[i]));
            }
            map.put(reversed, i);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}