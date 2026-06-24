class Solution {
    public int[] concatWithReverse(int[] nums) {
        int length = nums.length;
        int resultArray[] = new int[length * 2];
        for(int i = 0; i < length; i++){
            resultArray[i] = nums[i];
            resultArray[length + length - 1 - i] = nums[i];
        }
        return resultArray;

    }
}