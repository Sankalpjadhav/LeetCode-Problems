class Solution {
    public int minAddToMakeValid(String s) {
        int minRequired = 0;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                    minRequired++;
                }
                else{
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty()){
            minRequired++;
            stack.pop();
        }
        
        return minRequired;
    }
}