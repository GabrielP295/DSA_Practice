class Solution {
    public boolean isValid(String s) {
        /*
        Input: string of valid parentheses chars
        Output: whether string is a valid sequence of parentheses
        s will contain at least one parentheses
        string will never be valid if it's odd in length

        -Stack structure -> only add open parentheses to stack
        -if its closed we compare it to the last open pare on the stack -> remove that pare from stack
        -if not same type return false
        -check if the stack is empty, and return that
        ))
        */

        Map<Character, Character> parenthesesPairs = populateMap();
                Deque<Character> parenthesesStack = new ArrayDeque<>();

                        for (char parenthesis: s.toCharArray()) {
                                    if (!parenthesesPairs.containsKey(parenthesis)) {
                                                    parenthesesStack.push(parenthesis);
                                                                    continue;
                                                                                }
                                                                                            char matchingPair = parenthesesPairs.get(parenthesis);
                                                                                                        if (!parenthesesStack.isEmpty() && parenthesesStack.pop() != matchingPair) {
                                                                                                                        return false;
                                                                                                                                    }
                                                                                                                                                        }

                                                                                                                                                                return parenthesesStack.isEmpty();
                                                                                                                                                                    }

                                                                                                                                                                        private Map<Character, Character> populateMap() {
                                                                                                                                                                                Map<Character, Character> parenthesesPairs = new HashMap<>();
                                                                                                                                                                                        parenthesesPairs.put(')', '(');
                                                                                                                                                                                                parenthesesPairs.put('}', '{');
                                                                                                                                                                                                        parenthesesPairs.put(']', '[');
                                                                                                                                                                                                                return parenthesesPairs;
                                                                                                                                                                                                                    }
}
