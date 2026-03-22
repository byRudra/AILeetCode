class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int length = nums.length;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(nums[i].charAt(i) == '0')
                result.append('1');
            else
                result.append('0');
        }
        return result.toString();
    }
}