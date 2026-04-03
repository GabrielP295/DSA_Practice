class Solution {
    public boolean isValid(String s) {
        /*
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

        for (int i = 0; i < s.length(); i++) {
            boolean validSoFar = true;
            boolean foundClosing = false;
            char c = s.charAt(i);
            char charAtTop = c;
            if (!parenthesesStack.isEmpty()) {
                charAtTop = parenthesesStack.peekFirst();
            }
            if (c == ')' && !parenthesesStack.peekFirst().equals(null)) {
                validSoFar = charAtTop == '(';
                parenthesesStack.removeFirst();
                foundClosing = true;
            }
            if (c == '}' && !parenthesesStack.peekFirst().equals(null)) {
                validSoFar = charAtTop == '{';
                parenthesesStack.removeFirst();
                foundClosing = true;
            }
            if (c == ']' && !parenthesesStack.peekFirst().equals(null)) {
                validSoFar = charAtTop == '[';
                parenthesesStack.removeFirst();
                foundClosing = true;
            }
            if (!validSoFar) {
                return false;
            }
            if (!foundClosing) {
                parenthesesStack.addFirst(c);
            }
        }

        return true;
    }
}
