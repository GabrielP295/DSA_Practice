class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Input: array of integers btwn length 3 and 1000
        //Output: List of all distinct triplet values that add up to zero
        //*TRIPLET VALUES MUST NOT REPEAT
        //Triplets may appear in any order in both their own list and the output list

        /*
        -If a duplicate value is part of a triplet, you will get duplicate triplets
        -Brute force approach, iterate through the nums array and at each step you compute with every other
        value in the index, but at each of those steps you compute with every other value too
        
        -Three pointers when we iterate through the nums array, in order to track 3 diff positions
        [-1,0,1,2,-1,-4]
         ^            ^
        -HashSet for O(1) lookup of certain values, would js be a copy of nums array
        */

        Set<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            numsSet.add(num);
        }

        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int twoSum = nums[i] + nums[j];
                int neededThirdValue = 0 - twoSum;
                if (numsSet.contains(neededThirdValue)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.addAll(List.of(nums[i], nums[j], neededThirdValue));
                    triplets.add(triplet);
                }
            }
        }

        return triplets;
    }
}
