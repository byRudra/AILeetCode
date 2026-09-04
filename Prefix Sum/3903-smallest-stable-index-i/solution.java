// O(n ^ 2)
// class Solution {
//     public int firstStableIndex(int[] nums, int k) {
//         int max = nums[0];
//         for (int i = 0; i < nums.length; i++) {
//             int min = nums[i];
//             max = Math.max(max, nums[i]);
//             for (int j = i + 1; j < nums.length; j++) {
//                 min = Math.min(min, nums[j]);
//             }
//             if (max - min <= k)
//                 return i;
//         }
//         return -1;
//     }
// }

// O(n)
class Solution {
    public int firstStableIndex(int[] nums, int k) {
       int n = nums.length;
       // calculate min suffix for each with a backward pass 

       int suffixMin[] = new int[nums.length];
       suffixMin[n - 1] = nums[n - 1];
       for(int i = n - 2; i >= 0; i--){
        suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]); 
       } 
       int max = Integer.MIN_VALUE;
       for(int i = 0; i < n; i++){
        max = Math.max(max, nums[i]);
        if(max - suffixMin[i] <= k) return i;
       }
       return - 1;
    }
}