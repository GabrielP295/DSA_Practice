class Solution {
    public boolean isPalindrome(String s) {
        //Input: string of only printable ASCII chars
        //Output: boolean value that states whether input is palindrome or not
        //Palindrome is case insensitve and ignors all nonalphanumberic vals

        /*
        -Sort the string that's passed in //Time: O(nlogn)
        "car or ac?" -> "aaaaccooorr"
        -track if a odd valued group has been found
        -if another one is found, then false
        -return true

        -Two pointer approach where at each step you're checking
        if the two values at each end are equal
        "car or ac?"
         ^       ^ 
        -Check if either pointer value is a nonalphanumeric value,
        if it is skip for the pointer
        -Create a hashset that contains only alphanumberic values to use
        during checking of pointers
        */

        Set<Character> alphanumerics = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            alphanumerics.add((char)('A' + i));
            alphanumerics.add((char)('a' + i));
            if (i < 10) {
                alphanumerics.add((char)('0' + i));
            }
        }

        for(int i = 0; i < s.length(); i++) {
            int indexForStart = i;
            int indexForEnd = s.length() - i - 1;
            char startPointer = s.charAt(indexForStart);
            char endPointer = s.charAt(indexForEnd);
            while (!alphanumerics.contains(startPointer)) {
                startPointer = s.charAt(indexForStart++);
            }
            while (!alphanumerics.contains(endPointer)) {
                endPointer = s.charAt(indexForEnd--);
            }
            if (indexForStart >= indexForEnd) {
                return true;
            }
            if (Character.toLowerCase(startPointer) == Character.toLowerCase(endPointer)) {
                continue;
            }
            else {
                return false;
            }
        }
        return false; //this should never be reached with the given constraints
    }
}
