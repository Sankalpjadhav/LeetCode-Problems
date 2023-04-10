class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '{' || ch == '(' || ch == '['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                
                if(isSameBracket(ch, stack.peek())){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        
        if(!stack.isEmpty()){
            return false;
        }
        
        return true;
    }
    
    private boolean isSameBracket(char ch1, char ch2){
        if(ch1 == '}' && ch2 == '{'){
            return true;
        }
        
        if(ch1 == ']' && ch2 == '['){
            return true;
        }
        
        if(ch1 == ')' && ch2 == '('){
            return true;
        }
        
        return false;
    }
}