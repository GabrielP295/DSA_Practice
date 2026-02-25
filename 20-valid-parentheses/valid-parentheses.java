class Solution {
    public boolean isValid(String s) {
        /*
        Input: string of parentheses chars
        Output: boolean if string is valid
        string will contain at least one parenthesis
        if string is odd in length -> cannot be valid

        -Stack structure, iterate through string
        -if open parathesis add to the stack
        -if close parenthesis -> does it equal the top of the stack
        -if yes remove the corresponding open parenthesis (top of stack)
        -if not -> string is not valid
        */
        Deque<Character> parentheses = new ArrayDeque<>();
        Map<Character, Character> validParentheses = new HashMap<>();
        validParentheses.put(')', '(');
        validParentheses.put('}', '{');
        validParentheses.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            if (!validParentheses.containsKey(s.charAt(i))) {
                parentheses.push(s.charAt(i));
                continue;
            }
            if (!parentheses.isEmpty() && parentheses.peek() == validParentheses.get(s.charAt(i))) {
                parentheses.pop();
            }
            else  {
                return false;
            }
        }

        return parentheses.isEmpty();
    }
}
