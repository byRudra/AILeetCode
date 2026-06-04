class Solution {
    public int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {


        int minLandFinish = Integer.MAX_VALUE;
        int minWaterFinish = Integer.MAX_VALUE;

        for(int i = 0; i < landStartTime.length; i++){
            minLandFinish = Math.min(minLandFinish, landStartTime[i] + landDuration[i]);
        }

        for(int i = 0; i < waterStartTime.length; i++){
            minWaterFinish = Math.min(minWaterFinish, waterStartTime[i] + waterDuration[i]);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < waterStartTime.length; i++){
             int startWater =
                (minLandFinish <= waterStartTime[i])
                ? waterStartTime[i]
                : minLandFinish;

            ans = Math.min(ans, startWater + waterDuration[i]);
        }

        for(int i = 0; i < landStartTime.length; i++){
             int startLand =
                (minWaterFinish <= landStartTime[i])
                ? landStartTime[i]
                : minWaterFinish;

            ans = Math.min(ans, startLand + landDuration[i]);
        }
        return ans;
    }
}