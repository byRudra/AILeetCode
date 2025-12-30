class Solution {
    public int calGCD(int num1,int num2){
        while(num2 != 0){
            int temp = num2;
            num2 = num1 % num2; 
            num1 = temp;
        }
        return num1;
    }
    
    public int findGCD(int[] nums) {
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;

        for (int num : nums) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }

        return calGCD(minValue, maxValue);

    }
}