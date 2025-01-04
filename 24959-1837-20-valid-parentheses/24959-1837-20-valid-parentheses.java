class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isOpeningBracket(ch)){
                stack.push(ch);
            }
            else{
                // character is closing bracket
                
                if(stack.isEmpty()){
                    return false;
                }

                if(!compareBrackets(ch, stack.peek())){
                    return false;
                }

                stack.pop();
            }

        }

        if(stack.isEmpty()){
            return true;
        }

        return false;
    }

    public boolean isOpeningBracket(char ch){
        if(ch == '{' || ch == '(' || ch == '['){
            return true;
        }

        return false;
    }

    public boolean compareBrackets(char closingBracket, char openingBracket){
        if(openingBracket == '{' && closingBracket == '}') return true;
        if(openingBracket == '(' && closingBracket == ')') return true;
        if(openingBracket == '[' && closingBracket == ']') return true;
        return false;
    }
}