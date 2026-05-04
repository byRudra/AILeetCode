class Solution {
    public int findDuplicate(int[] nums) {
        int arr[] = new int[nums.length];
        for (int num : nums) {
            arr[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] > 1)
                return i;
        }
        return -1;

    }
}