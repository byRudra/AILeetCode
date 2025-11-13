class Solution {
    public int jump(int[] nums) {
        // Greedy Approach

        int maxJump = 0, count = 0, currEnd = 0;

        for(int i = 0; i < nums.length - 1; i++){
            maxJump = Math.max(maxJump, i + nums[i]);

            if(i == currEnd){
                count++;
                currEnd = maxJump;
            }

            // if(currEnd >= nums.length - 1 ) return count;

        }
        return count;

    }
}