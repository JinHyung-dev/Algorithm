class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int p = 0;
        int start = 0;
        while(p <= nums.length - 1) {
            if(nums[start] != nums[p]) {
                start++;
                nums[start] = nums[p];
            }
            p++;
        }

        return start + 1;
    }
}