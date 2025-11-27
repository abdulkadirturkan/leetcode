class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')','(');
        matchingBrackets.put(']','[');
        matchingBrackets.put('}','{');

        for(char c : s.toCharArray()){
            if(matchingBrackets.containsKey(c)){
                if(stack.isEmpty() || stack.peek() != matchingBrackets.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
