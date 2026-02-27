class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        Input: array of strings
        Output: list of grouped string list that hold anagrams

        strings array gurantee to have 1 value
        length of string btwn 0 and 1
        words will only be made of lowercase 

        -character frequency / sorted words -> map the same lists into one list
        -hashMap key of array of lowercase letters, values is the list of group anagrams
        -Hashmap key cannot be a mutable object
        */

        Map<String, List<String>> grouped = new HashMap<>();

        for (String str : strs) {
            // char[] characters = str.toCharArray();
            // Arrays.sort(characters);
            // String sorted = new String (characters);
            int[] charCount = new int[26];
            for (char c : str.toCharArray()) {
                charCount[c - 'a'] += 1;
            }
            String sorted = Arrays.toString(charCount);

            List<String> currentList = grouped.getOrDefault(sorted, new ArrayList<>());
            currentList.add(str);
            grouped.put(sorted, currentList);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : grouped.values()) {
            result.add(group);
        }
        return result;
    }
}
