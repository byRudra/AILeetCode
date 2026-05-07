class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int currentConsecutive = 0;
        for(int num: nums){
            if(num == 1){
                currentConsecutive++;
                maxConsecutive = Math.max(currentConsecutive, maxConsecutive);
            }
            else{
                currentConsecutive = 0;
            }
        }
        return maxConsecutive;
    }
}