class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        
        String result = "";
        
        while(!stack.isEmpty() ){
            result = stack.pop() + result;
        }
        
        return result;
    }
}