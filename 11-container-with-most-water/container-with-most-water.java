class Solution {
    public int maxArea(int[] arr) {
    /*
    Input: integer array where element represents height of vertical line at index
    Output: maximum amount of water that a container can hold
    Edge case: must be done with two different lines
    Ex. [1, 2, 5, 3]
               ^  ^
    -Container is limited by the smaller value since going over would cause overflow

    Approach:
    - Window with two pointers to move our optimal areas
    - Moving inwards is guranteed to give a smaller value if heights stayed the same -> we must
    find a height that increases our area
    - Limited by the smaller value, so move our window inwards depending on smallest
     */

        int left = 0, right = arr.length - 1, maxArea = 0;

        while (left < right) {
            int limitingHeight = Math.min(arr[left], arr[right]);
            maxArea = Math.max(maxArea, limitingHeight * (right - left));

            if (arr[left] > arr[right]) {
                right--;
            }
            else {
                left++;
            }
        }

        return maxArea;
    }
}
