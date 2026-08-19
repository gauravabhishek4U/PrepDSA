class Solution {
    public boolean isValid(String s) {
        Deque <Character> stack = new ArrayDeque<>();

        // pushing 0 initially to check if omission of valid parentheses at the end
        stack.push('0');

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == ')' && stack.peek() == '('){
                stack.pop();
            }
            else if(ch == '}' && stack.peek() == '{'){
                stack.pop();
            }
            else if(ch == ']' && stack.peek() == '['){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }

        // if all parentheses are valid, then it must have been popped out with only 0 remaining at the top of the stack
        if(stack.peek() == '0'){
            return true;
        }
        
        return false;
    }
}