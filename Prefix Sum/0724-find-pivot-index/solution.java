class Solution {
    // Two Array Approach
    // public int pivotIndex(int[] nums) {
    //     // Two Array Approach
    //     int size = nums.length;
    //     int leftSum[] = new int[size];
    //     int rightSum[] = new int[size];

    //     // Calculate left sums (excluding current element)
    //     leftSum[0] = 0;
    //     for (int i = 1; i < size; i++) {
    //         leftSum[i] = leftSum[i - 1] + nums[i - 1];
    //     }

    //     // Calculate right sums (excluding current element)
    //     rightSum[size - 1] = 0;
    //     for (int i = size - 2; i >= 0; i--) {
    //         rightSum[i] = rightSum[i + 1] + nums[i + 1];
    //     }

    //     // Find pivot index
    //     for (int i = 0; i < size; i++) {
    //         if (leftSum[i] == rightSum[i]) {
    //             return i;
    //         }
    //     }

    //     return -1;
    // }

    // Better Approach Less Space Complexity
    public int pivotIndex(int[] nums) {
        int leftSum = 0, totalSum = 0;
        for(int num: nums) totalSum += num;

        for(int i =0; i < nums.length; i++){
            int rightSum = totalSum - leftSum - nums[i];

            if(rightSum == leftSum) return i;

            leftSum += nums[i];
        }

        return -1;
    }
}