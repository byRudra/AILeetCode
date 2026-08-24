class Solution {
    public int heightChecker(int[] heights) {
        int expectedHeight[] =  heights.clone();;
        Arrays.sort(expectedHeight);
        int count = 0;
        for(int i = 0; i < heights.length; i++){
            if(expectedHeight[i] != heights[i]) count++;
        }
        return count;
    }
}