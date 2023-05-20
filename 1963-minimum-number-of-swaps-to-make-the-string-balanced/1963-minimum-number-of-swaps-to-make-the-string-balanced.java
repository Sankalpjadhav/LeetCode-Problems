class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int extra = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '['){
                stack.push(ch);
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    extra++;
                }
            }
        }
        
        return (extra + 1) / 2;
    }
}