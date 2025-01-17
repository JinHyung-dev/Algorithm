class Solution {
    public boolean isValid(String s) {
        if(s.length() %2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                char open = stack.pop();
                if(!isMatch(open, c)) return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isMatch(char open, char target) {
        return (open == '(' && target == ')') ||
                (open == '[' && target == ']') ||
                (open == '{' && target == '}');
    }
}