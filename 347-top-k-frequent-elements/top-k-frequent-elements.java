class Solution {
        /*
    Input: array of ints and integer k
    Output: return k most frequent ints in input arr
    - Answer can be returned in any order, ties between number are not possible
    Ex. [5, 2, 6, 3, 3, 9, 2, 2], k = 2 -> [2, 3]

    Approach:
    - iteration through input array to track frequencies
    - one appraoch could be save frequency as key and numbers as values in hashmap,
    then sort a collection of the keys and iterate through backwards k times -> time O(nlogn)

    - array of size of input array + 1 because we can store chars at their index to track freq then
    iterate through backwards k times -> Time: O(n)
    - still use hashmap to track freq per number -> two passes of input, one to populate map, then one to populate arr
     */

    // NOTE: USE A LIST OF LIST INSTEAD, java generics don't mix well with arrays
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[]{};
        //keys: numbers, values: freq
        Map<Integer, Integer> intFreq = new HashMap<>();
        List<Integer>[] topK = new ArrayList[nums.length + 1];
        for (int i = 0; i < topK.length; i++) {
            topK[i] = new ArrayList<>();
        }
        int[] results = new int[k];

        for (int num : nums) {
            intFreq.put(num, intFreq.getOrDefault(num, 0) + 1);
        }
        for (int num : intFreq.keySet()) {
            int index = intFreq.get(num);
            topK[index].add(num);
        }

        int indexEnd = topK.length - 1;
        int indexStart = 0;
        while (indexStart < k) {
            List<Integer> numbers = topK[indexEnd];
            for (int num : numbers) {
                results[indexStart] = num;
                indexStart++;
            }
            indexEnd--;
        }

        return results;
    }
}