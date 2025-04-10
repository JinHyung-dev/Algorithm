class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;

        int startIdx = 0; int endIdx = nums.length - 1;

        while(startIdx < endIdx) {

            int midIdx = startIdx + (endIdx- startIdx) / 2;

            if(nums[midIdx] < nums[midIdx + 1]) {
                startIdx = midIdx + 1;
            } else {
                endIdx = midIdx;
            }
        }
        return startIdx;
    }
}