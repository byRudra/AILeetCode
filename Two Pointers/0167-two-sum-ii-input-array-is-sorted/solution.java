class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){return new int[]{ ++left, ++right};}

            if(sum < target){
                left++;
            }
            if(sum > target){
                right--;
            }
        }
        return new int[]{};
    }
}