class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <nums2.length; i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i]) 
                nextGreaterMap.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        while(!stack.isEmpty()){
            nextGreaterMap.put(stack.pop(), -1);
        }
        int result[] = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++){
            result[i] = nextGreaterMap.get(nums1[i]);
        }
        return result;
    }
}
