class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) return ranges;
        if (nums.length == 1) {
            ranges.add(nums[0] + "");
            return ranges;
        }
        int currentIndex = 0;
        for(int rangeStart = 0; rangeStart < nums.length; rangeStart++){
            currentIndex = rangeStart + 1;
            while(currentIndex < nums.length && nums[currentIndex] - nums[currentIndex - 1] == 1){ currentIndex++; }

            if(nums[rangeStart] == nums[currentIndex - 1]){ ranges.add(nums[rangeStart] + ""); }
            else{ ranges.add(nums[rangeStart] + "->" + nums[currentIndex - 1]); }
            rangeStart = currentIndex - 1;
        }
        return ranges;
    }
}