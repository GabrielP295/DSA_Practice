class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        /*
        Input: array of distinct integers
        Output: list of pairs in ascending order in which b - a = minimum absolute diff of original array
        absolute value of differences
        input array will contain at least 2 values

        -brute force to calculate every diff
        -To store a and b values use HashMap -> difference is the key, and the pairs are the values
        -retrieve key with smallest difference and return this as result
        [1, 2, 3, 4]
        [-14, -10, -4, 3, 8, 19, 23, 27] -> smallest difference can only occur at adjacent elements 
        */

        Map<Integer, List<List<Integer>>> pairs = new HashMap<>();
        Arrays.sort(arr);
        int left = 0;
        int right = 1;
        int smallestDiff = 0;

        while (right < arr.length) {
            int absoluteDiff = Math.abs(arr[right] - arr[left]);
            smallestDiff = absoluteDiff;
            List<Integer> pair = new ArrayList<>();
            pair.add(arr[left]);
            pair.add(arr[right]);

            List<List<Integer>> storedPairs = pairs.getOrDefault(absoluteDiff, new ArrayList<>());
            storedPairs.add(pair);
            pairs.put(absoluteDiff, storedPairs);
            left++;
            right++;
        }

        for (int diff : pairs.keySet()) {
            smallestDiff = Math.min(diff, smallestDiff);
        }
        return pairs.get(smallestDiff);
    }
}