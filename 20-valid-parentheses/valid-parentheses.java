class Solution {
    public boolean isValid(String s) {
        /*
        NOTE AFTER PROBLEM: NOT OPTIMIZED SOLUTION, LOOKING TO COME BACK TO LATER TO CLEAN UP

        Input: string consisting of only parathesis type chars
        Output: boolean stating whether is valid
        3 things:
        -open bracket must be closed by same type -> ( )
        -open brackets must be closed within a valid sequence -> [(])
        -every close has a corresponding open same type
        ([{[}]])

        -Stack -> start of string 
        -if a para of diff type is added, it must be the start of a para sequence
        -if one of the same type as top of stack, consider that closed -> remove from stack 2 values
        -any closing type of parathesis added to stack must match type of para at top of stack
        */
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> parenthesesStack = new ArrayDeque<>();
        int opening = 0;
        int closing = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean validSoFar = true;
            boolean foundClosing = false;
            char c = s.charAt(i);
            char charAtTop = c;
            if (!parenthesesStack.isEmpty()) {
                charAtTop = parenthesesStack.peekFirst();
            }
            if (c == ')' && parenthesesStack.peekFirst() != null) {
                validSoFar = charAtTop == '(';
                parenthesesStack.removeFirst();
                foundClosing = true;
                closing++;
            }
            if (c == '}' && parenthesesStack.peekFirst() != null) {
                validSoFar = charAtTop == '{';
                parenthesesStack.removeFirst();
                foundClosing = true;
                closing++;
            }
            if (c == ']' && parenthesesStack.peekFirst() != null) {
                validSoFar = charAtTop == '[';
                parenthesesStack.removeFirst();
                foundClosing = true;
                closing++;
            }
            if (!validSoFar) {
                return false;
            }
            if (!foundClosing) {
                parenthesesStack.addFirst(c);
                opening++;
            }
        }
        if (opening != closing) {
            return false;
        }

        return true;
    }
}
