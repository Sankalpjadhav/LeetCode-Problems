class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch != '*'){
                stack.push(ch);
            }
            else{
                stack.pop();
            }
        }
        
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        
        return result.reverse().toString();
    }
}