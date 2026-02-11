class Solution {
    public boolean isPalindrome(String s) {
        //Input: string made up of valid ASCII characters
        //Output: boolean value stating whether or not the string is a palindrome
        //Palindrome is case insensistve and ignores non alphanumeric characters
        //skip any non alphanumeric char, and when comparing we have to convert all chars to lowercase

        /*
        -HashMap to store the characters (key) and # of times they appear (values)
        -Check if there is more than one instance of odd values, then the word isn't a palindrome

        -Having two pointers to track whether each end of the string is equal to each other
        -One pointer that starts at the beginning, and one that starts at the end
        -Increment and decrement the pointers respectively
        -conditional that checks if character is valid, and if not move the pointer in the corresponding direction
        */
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        while (leftPointer < rightPointer) {
            char leftChar = s.charAt(leftPointer);
            char rightChar = s.charAt(rightPointer);

            while (!isAlphanumeric(leftChar) && leftPointer < rightPointer) {
                leftPointer++;
                leftChar = s.charAt(leftPointer);
            }

            while (!isAlphanumeric(rightChar) &&  leftPointer < rightPointer) {
                rightPointer--; 
                rightChar = s.charAt(rightPointer);
            }

            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    public boolean isAlphanumeric(char c) {
        return c >= 'A' && c <= 'Z' ||
               c >= 'a' && c <= 'z' ||
               c >= '0' && c <= '9';
    }
}