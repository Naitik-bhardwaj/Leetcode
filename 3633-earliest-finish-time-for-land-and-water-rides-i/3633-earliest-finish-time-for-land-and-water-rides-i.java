class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //land to water
                int finishLand = landStartTime[i] + landDuration[i];
                int total1 = Math.max(finishLand, waterStartTime[j]) + waterDuration[j];

                //water to land
                int finishWater = waterStartTime[j] + waterDuration[j];
                int total2 = Math.max(finishWater, landStartTime[i]) + landDuration[i];

                min = Math.min(min, Math.min(total1, total2));
            }
        }
        return min;
    }
}