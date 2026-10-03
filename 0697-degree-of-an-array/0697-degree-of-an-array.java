class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] count = new int[50000];
        int[] first = new int[50000];
        int[] last = new int[50000];
        int degree = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (count[num] == 0) {
                first[num] = i;
            }
            last[num] = i;
            count[num]++;
            degree = Math.max(degree, count[num]);
        }
        
        int minLength = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (count[num] == degree) {
                minLength = Math.min(minLength, last[num] - first[num] + 1);
                count[num] = 0; 
            }
        }
        
        return minLength;
    }
}