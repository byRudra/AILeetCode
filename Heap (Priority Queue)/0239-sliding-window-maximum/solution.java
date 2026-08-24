// class Solution {
//     public int maxSlide(int[] nums) {
//         int maxNum = Integer.MIN_VALUE;
//         for (int num : nums)
//             maxNum = Math.max(maxNum, num);
//         return maxNum;
//     }

//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int max = Integer.MIN_VALUE;
//         int start = 0;
//         int end = start + k;
//         ArrayList<Integer> list = new ArrayList<>();

//         for (; end <= nums.length; end++) {
//             int currArr[] = new int[k];
//             int arrStart = start;
//             for (int i = 0; i < k; i++) {
//                 currArr[i] = nums[arrStart++];
//             }
//             list.add(maxSlide(currArr));
//             start++;
//         }
//         int[] result = new int[list.size()];

//         for (int i = 0; i < list.size(); i++) {
//             result[i] = list.get(i);
//         }

//         return result;

//     }
// }


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> nums[i2] - nums[i1]);
            int result [] = new int[nums.length - k + 1];
            int j = 0;
            for(int i = 0; i < nums.length; i++){
                while(!maxHeap.isEmpty() && maxHeap.peek() < i - k + 1) maxHeap.poll();
                maxHeap.add(i);
                if(i >= k - 1) result[j++] = nums[maxHeap.peek()];
            }
            return result;

    }
}