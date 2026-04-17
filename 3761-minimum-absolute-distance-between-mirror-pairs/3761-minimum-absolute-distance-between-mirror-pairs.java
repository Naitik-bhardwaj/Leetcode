class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int rev = reverse(nums[i]);
            if(map.containsKey(nums[i])){
                min = Math.min(min, i-map.get(nums[i]));
            }
            map.put(rev, i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public int reverse(int n){
        int sign = (n<0) ? -1 : 1;
        n = Math.abs(n);
        int rev = 0;
        while(n > 0){
            rev = (rev*10) + (n%10);
            n = n/10;
        }
        return sign * rev;
    }
}