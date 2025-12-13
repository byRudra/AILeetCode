// This approach fails because leetCode dosent allow long and it is a big overloading for bigger integers.
// class Solution {
//     public static int combine(int[] arr) {
//         int result = 0;

//         for (int i = 0; i < arr.length; i++) {
//             result = result * 10 + arr[i];
//         }

//         return result;
//     }
//     public List<Integer> resultArray(int num){
//         List<Integer> nums = new ArrayList<>();
//         if(num == 0){
//             nums.add(0);
//             return nums;
//         }

//         while(num > 0){
//             nums.add(num % 10);
//             num /= 10;
//         }
//         java.util.Collections.reverse(nums);
//         return nums;
//     }
//     public List<Integer> addToArrayForm(int[] num, int k) {
//         int combined = combine(num);
//         int result = combined + k;
//         return resultArray(result);
//     }
// }
// Approach doing bit wise addisiion
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int i = num.length - 1;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
                i--;
            }
            res.add(k % 10);
            k /= 10;
        }

        Collections.reverse(res);
        return res;
    }
}