class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int arrayResult[] = new int[nums.length];
        int index = 0;
        for(int num : nums){
            if(num < pivot){
                arrayResult[index++] = num;
            }
        }
        for(int num : nums){
            if(num == pivot){
                arrayResult[index++] = num;
            }
        }
        for(int num : nums){
            if(num > pivot){
                arrayResult[index++] = num;
            }
        }
        return arrayResult;
    }
}