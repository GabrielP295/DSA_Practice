class Solution {
    public int search(int[] nums, int target) {
        /*
        Input: array of distinct int sorted in asc, and an integer target
        Output: the index at which target is located
        This algorithm must run O(log n)
        nums will contain at least one value
        all integers in nums are unique

        -binary search -> divide and conquer to split the list into sections over and over
        -requires sorting, eliminate one half of each split, unitl we reach value
        */
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int m = left + ((right - left) / 2);
            if (nums[m] < target) {
                left = m + 1;
            }
            else if (nums[m] > target) {
                right = m - 1;
            }
            else {
                return m;
            }
        }

        return -1;
    }
}
