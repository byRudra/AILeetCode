class Solution {
    public int[] leftRightDifference(int[] nums) {
        int length = nums.length;
        int rightSum = 0;
        int leftSum = 0;
        int resultArray[] = new int[length];
        for(int num : nums){
            rightSum += num;
        }
        //now right sum = sum of all elements in nums

        //question wants an array where each index has the value of rightSum - leftSum - currentElement;
        for(int i = 0; i < length; i++){
            resultArray[i] = Math.abs(rightSum - leftSum - nums[i]);
            rightSum -= nums[i];
            leftSum += nums[i];
        }
        return resultArray;


    }
}