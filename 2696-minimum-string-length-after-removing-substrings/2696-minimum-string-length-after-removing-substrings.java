class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'B' || ch == 'D'){
                if(ch == 'B'){
                    if(!stack.isEmpty() && stack.peek() == 'A'){
                        stack.pop();
                    }
                    else{
                        stack.push(ch);
                    }
                }
                else{
                    if(!stack.isEmpty() && stack.peek() == 'C'){
                        stack.pop();
                    }
                    else{
                        stack.push(ch);
                    }
                }
            }
            else{
                stack.push(ch);
            }
        }
        
        return stack.size();
    }
}