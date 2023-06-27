class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Stack<String> stack = new Stack<>();
        int score = 0;
        
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push("(");
            }
            else{
                if(stack.peek() == "("){
                    stack.pop();
                    stack.push("1");
                }
                else{
                    int sum = 0;
                    
                    while(stack.peek() != "("){
                        sum += Integer.parseInt(stack.peek());
                        stack.pop();
                    }
                    
                    stack.pop();
                    stack.push(String.valueOf(2*sum));
                }
            }
        }
        
        while(!stack.isEmpty()){
            score += Integer.parseInt(stack.pop());
        }
        
        return score;
    }
}