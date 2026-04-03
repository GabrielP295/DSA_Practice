class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        -Input: array of integers 
        -Output: The length of the longest consecutive sequence that can be formed from input
        input can be of length 0 or higher(until 1000)
        Returned sequence doesn't have to be consecutive within original input array

        -Sorting the input array, track until the next index doesn't continue the array
        -At each step we would save the length of the current sequence and compare it to the current
        longest sequence stored
        -Time: O(nlogn)

        -HashSet, hashsets allow constant lookup
        -2 -> check if 3 is in the hashset
        -How would we avoid unneccessary checks of sequences
        -We would need an algorithm to find the start of a sequence
        -Use the hashset to check if the previous value exists ie 2 -> check if 1 exists
            if it does we know that's not the start of a sqeucne and we can skip it
            but if it doesn't then the 2 is the start
        */
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> numsSet = new HashSet<>();

        for (int num:nums) {
            numsSet.add(num);
        }

        int longestSequence = 1;

        for (int num : nums) {
            if (numsSet.contains(num - 1)) {
                continue;
            }
            int currentValue = num;
            //num = 2, currentValue = 2, currentValue = 3, longestSequence = 2
            while (numsSet.contains(currentValue + 1)) {
                currentValue++;
                longestSequence++;
            }
        }

        return longestSequence;
    }
}
