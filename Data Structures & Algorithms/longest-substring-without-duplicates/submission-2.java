class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        Input: string made up of any chars
        Output: length of the longest substring within that string that contains
        no duplicates
        -length of string can be 0
        -Problem is case sensitive

        -Brute force -> check every combo of substring 
        -if no duplicates contained then its considered valid

        jieccwsk
            ^  ^
        -Using two pointers to shrink and expand a sliding window
        -Allows us to maximize the length while ensuring we have a valid substirng
        */ 
        int left = 0;
        int right = 0;
        int longestLength = 0;

        while (right < s.length()) {
            Set<Character> seenChars = new HashSet<>();
            seenChars.add(s.charAt(left));
            while(right < s.length() && !seenChars.contains(s.charAt(right))) {
                seenChars.add(s.charAt(right));
                right++;
            }
            longestLength = Math.max(longestLength, right - left);
            left = right;
            right++;
        }

        return longestLength;
    }
}
