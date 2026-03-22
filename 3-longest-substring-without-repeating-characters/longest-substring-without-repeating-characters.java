class Solution {
            /*
    Input: string
    Output: length of longest substring with no repeats
    Constraints: case sensitive characters, valid ASCII chars
    Ex. "abcbdefbaaccdefghho" -> 6
         ^ ^

    Approach: we only need to return the longest length, not the actual substring
    - sliding window that moves once the invariant -> substring with repeating chars
    - if substring becomes invalid, increment left +1 until substring becomes valid again
    - if substtring is valid then we increment only right pointer +1
    - no need to store actual substring, just a result that stores longest length
     */

    public int lengthOfLongestSubstring(String str) {
        int longest = 0;
        int left = 0;
        int right = 0;
        Set<Character> seenChars = new HashSet<>();

        while (right < str.length()) {
            while (seenChars.contains(str.charAt(right))) {
                seenChars.remove(str.charAt(left));
                left++;
            }
            seenChars.add(str.charAt(right));
            right++;
            longest = Math.max(right - left, longest);
        }

        return longest;
    }
}