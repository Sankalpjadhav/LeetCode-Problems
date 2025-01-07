class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            if(isOperator(tokens[i])){
                int num2 = stack.pop();
                int num1 = stack.pop();

                if(tokens[i].equals("+")){
                    stack.push(num1 + num2);
                }
                else if(tokens[i].equals("-")){
                    stack.push(num1 - num2);
                }
                else if(tokens[i].equals("*")){
                    stack.push(num1 * num2);
                }
                else{
                    stack.push(num1 / num2);
                }
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();

    }

    private boolean isOperator(String token){
        if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
            return true;
        }

        return false;
    }
}