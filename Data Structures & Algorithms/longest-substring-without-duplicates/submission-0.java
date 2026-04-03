class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        Input: string of valid AscII chars
        Output: length of the longest substring without duplicates
        Length of string is 0 <= x <= 1000

        -The actual substring doesn't matter, we just need to know the longest length
        -Create a new data structure that tracks already seen values as we iterate through strings
        -We reset (empty) the data structure when a duplicate is found 
        -HashSet fast lookup
        */

        int longestLength = 0;
        int currentLength = 0;
        Set<Character> seenChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (seenChars.contains(s.charAt(i))) {
                seenChars = new HashSet<>();
                i--;
                currentLength = 0;
                continue;
            }
            seenChars.add(s.charAt(i));
            currentLength++;
            longestLength = Math.max(currentLength, longestLength);
        }

        return longestLength;
    }
}
