class Solution {
    public int[] productExceptSelf(int[] nums) {
        int result[] = new int [nums.length];

        result[0] = 1;

        for(int i = 1; i < nums.length; i++){
            result[i] = result[i - 1] * nums[i - 1];
        }

        int rightProd = 1;

        for(int j = nums.length - 1; j >= 0; j--){
            result[j] *= rightProd;
            rightProd *=  nums[j]; 
        }
        return result;
    }
}