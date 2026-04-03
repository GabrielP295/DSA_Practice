class Solution {
    public int longestConsecutive(int[] nums) {
        //Input: array of integers
        //Output: length of the longest consecutive sequence of elements that can be formed
        //Consecutive = each element is 1 greater than previous
        /*
        KEY: Not looking for consecutive sequence already ordered in nums, instead
        looking to form the longest consecutive sequence and return its length
        */
        //Time Complexity: O(n)

        /*
        -iterate through nums, and at each step look through the whole array to find a
        value thats 1 greater than the current one

        *dont actually need to keep track of the longest sequence, just the longest length
        -sorting the original array and iterating through it 
        -if nextVal=currentVal, continue through the loop
        -if nextVal isn't 1 greter or equal to curretn val, restart the longest length tracker
        longestLength, currentLength
        */

        int[] sortedNums = nums;
        Arrays.sort(sortedNums);
        int longestLength = 1;
        int currentLength = 1;

        for (int i = 0; i < sortedNums.length - 1; i++) {
            int currentValue = sortedNums[i];
            int nextValue = sortedNums[i + 1];
            if (currentValue == nextValue) {
                continue;
            }
            if (currentValue + 1 != nextValue) {
                currentLength = 1;
                continue;
            }
            currentLength++;
            if (currentLength > longestLength) {
                longestLength = currentLength;
            }
        }
        return longestLength;
    }
}
