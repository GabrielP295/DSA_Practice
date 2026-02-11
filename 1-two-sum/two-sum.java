class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        Input: array of integers and a target number
        Output: array of integers that represents the indices of two numbers in nums that add up to target
        nums will contain at least 2 values
        we can assume each input will contain at least one solution
        The same element at one index may not be used twice

        -Brute force would be iterating through nums and at each step checking every possible combination until target is found
        -Isn't optimal -> Time complexity would run at o(n^2)

        2 + x = 9 -> x = 9 - 2 = 7
        -HashMap to store the numbers in nums (key) and store their indices (values)
        -Iterate through nums array and at each step check if the target - currentVal is within the HashMap
        -If it is we take the value (index) and add it to our output along with the current index in nums that we're on
        */
        Map<Integer, Integer> numsAndIndices = new HashMap<>();
        int[] twoSum = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            int missingValue = target - currentValue;
            if (numsAndIndices.containsKey(missingValue)) {
                int indexToAdd = numsAndIndices.get(missingValue);
                twoSum[0] = i;
                twoSum[1] = indexToAdd;
                return twoSum;
            }
            numsAndIndices.put(currentValue, i);
        }

        return twoSum;
    }
}