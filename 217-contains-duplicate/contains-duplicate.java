class Solution {
    public boolean containsDuplicate(int[] nums) {
        //Input: nums integer array that can possibly have duplicates
        //Output: boolean value that tells us whether input array has duplicates
        //Edge case: empty array or a array with one value(not possible to have duplicates)

        //arraylist structure where we add values from nums
        //iterate through nums checking if the arraylist already contains the value were trying to add
        //looping through the arraylist and if it does have that val, we can early return true since dupe found
        //if this whole process without finding dupes, return false

        /*
        -HashSet which gurantees O(1) based on hash values
        -we can check if value exists within the set with contains()
        -iterate through nums, at each step we add the value to the hashset if it doesn't contain that
        -if it does early return true
        */

        //Space: O(n) Time: O(n) lookup: O(1) -> O(n)

        Set<Integer> duplicateChecker = new HashSet<>();

        for (int num : nums) {
            if (duplicateChecker.contains(num)) {
                return true;
            }
            duplicateChecker.add(num);
        }
        return false;
    }
}