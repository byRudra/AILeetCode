class Solution {
    public int[] rearrangeArray(int[] nums) {
        int []result = new int[nums.length];
        int pos = 0, neg = 1;
        for(int num : nums){
            if(num >= 0){
                result[pos] = num;
                pos += 2;
            }
            else{
                result[neg] = num;
                neg += 2;
            }
        }
        return result;
    }
}