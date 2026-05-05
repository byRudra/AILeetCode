class Solution {
    // O(n log(n))
    // public int majorityElement(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums[nums.length / 2];
    // }

    // O(n)
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            
            if (candidate == nums[i])
                count++;
            else
                count--;

            if(count == 0){
                count = 1;
                candidate = nums[i];
            }
        }
        return candidate;
    }
}