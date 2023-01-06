class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        
        if(n == k){
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<n;i++){
            char ch = num.charAt(i);
            // stack top element is greater than current element, remove the top element
            while(k > 0 && !stack.isEmpty() && stack.peek() > ch){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        
        while(k > 0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        sb.reverse();
        
        //System.out.println(num + "->" + sb);
        
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}