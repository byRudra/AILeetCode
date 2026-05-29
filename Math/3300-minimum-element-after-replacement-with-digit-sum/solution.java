class Solution {
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            minSum = Math.min(minSum, sumDigit(nums[i]));
        }   
        return minSum;
    }
    private int sumDigit(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}