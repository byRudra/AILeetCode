class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallestNo = Integer.MAX_VALUE;
        boolean isAllEven = true;

        for(int num : nums1){
            smallestNo = Math.min(smallestNo, num);
            if(num % 2 != 0) isAllEven = false;
        }
        return (smallestNo % 2 == 1) || isAllEven;
    }
}