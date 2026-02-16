class Solution {
    public int maxArea(int[] heights) {
        /*
        Input: array of integers representing heights where each value is the height of a bar and index is its location
        Output: the max amount of water that can be stored in a container(area)
        There will be at least two height
        All height values will either be zero or positive

        Brute force:Calculating every single possibility -> O(n^2)

        [1, 6, 3, 9]
        -Area is limited by the smaller height
        -Start at the end of the list to start by maximizing the length attribute
        */

        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int maxArea = 0;

        while (leftPointer < rightPointer) {
            int length = rightPointer - leftPointer;
            int height = Math.min(heights[leftPointer], heights[rightPointer]);
            maxArea = Math.max(height*length, maxArea);
            if (heights[leftPointer] > heights[rightPointer]) {
                rightPointer--;
            }
            else {
                leftPointer++;
            }
        }

        return maxArea;
    }
}
