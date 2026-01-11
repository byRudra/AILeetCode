// class Solution {
//     public void rotate(int[] nums, int k) {
//         if (k == 0) return;
//         int res [] = new int[nums.length];
//         for(int i = 0; i < nums.length; i++){
//                 // 1 2 3 4 rotate 2 times
//                 // 4 1 2 3 
//                 // 3 4 1 2
//                 int newIndex = (i + k) % nums.length;
//                 res[newIndex] = nums[i];
//             }
//         for(int i = 0; i < nums.length; i++){
//             nums[i] = res[i];
//         }
//     }
// }

// better approach

class Solution{
    public void rotate(int []nums, int k){
        int length = nums.length;
        k = k % length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k , length - 1);


    }
    private void reverse(int[]nums,int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end--;
        }
    }
}