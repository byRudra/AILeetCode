class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] result = new int[size];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < size; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prevDay = stack.pop();

                result[prevDay] = i - prevDay;
            }
            stack.push(i);
        }

        return result;
    }
}