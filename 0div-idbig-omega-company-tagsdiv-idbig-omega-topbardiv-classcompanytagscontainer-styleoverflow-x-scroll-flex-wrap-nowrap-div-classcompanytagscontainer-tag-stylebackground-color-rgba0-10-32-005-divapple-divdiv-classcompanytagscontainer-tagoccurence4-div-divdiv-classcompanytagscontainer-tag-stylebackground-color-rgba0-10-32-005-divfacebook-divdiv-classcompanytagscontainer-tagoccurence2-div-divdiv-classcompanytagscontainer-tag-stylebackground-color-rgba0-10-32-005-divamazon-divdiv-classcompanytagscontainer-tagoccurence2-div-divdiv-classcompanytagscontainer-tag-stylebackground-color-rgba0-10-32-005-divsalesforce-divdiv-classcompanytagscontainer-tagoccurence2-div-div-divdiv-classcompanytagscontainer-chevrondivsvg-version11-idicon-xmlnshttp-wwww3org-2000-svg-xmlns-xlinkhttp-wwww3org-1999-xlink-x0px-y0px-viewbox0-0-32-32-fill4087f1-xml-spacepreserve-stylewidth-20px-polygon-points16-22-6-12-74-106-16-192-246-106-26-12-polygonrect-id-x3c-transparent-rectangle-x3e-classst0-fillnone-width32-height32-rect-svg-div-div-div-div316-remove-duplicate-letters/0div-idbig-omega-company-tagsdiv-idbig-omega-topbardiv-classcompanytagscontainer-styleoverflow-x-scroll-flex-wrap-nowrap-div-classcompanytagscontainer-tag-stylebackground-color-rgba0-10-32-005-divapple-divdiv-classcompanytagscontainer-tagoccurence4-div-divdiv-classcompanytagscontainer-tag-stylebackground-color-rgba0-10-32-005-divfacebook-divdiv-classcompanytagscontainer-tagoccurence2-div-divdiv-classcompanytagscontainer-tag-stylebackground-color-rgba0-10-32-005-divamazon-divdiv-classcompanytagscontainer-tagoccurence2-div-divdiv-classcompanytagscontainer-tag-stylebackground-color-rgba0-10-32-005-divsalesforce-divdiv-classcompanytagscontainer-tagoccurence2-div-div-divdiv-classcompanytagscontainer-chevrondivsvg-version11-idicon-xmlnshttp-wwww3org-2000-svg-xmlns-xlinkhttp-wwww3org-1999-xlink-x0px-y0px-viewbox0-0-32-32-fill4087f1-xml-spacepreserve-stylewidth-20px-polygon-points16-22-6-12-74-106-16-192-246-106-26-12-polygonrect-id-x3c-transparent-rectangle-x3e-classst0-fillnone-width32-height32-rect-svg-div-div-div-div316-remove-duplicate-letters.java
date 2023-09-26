class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        
        int [] lastIndex = new int[26];
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }
        
        boolean [] visited = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            
            if(visited[ch - 'a']) continue;
            
            while(!stack.isEmpty() && stack.peek() > (ch - 'a') && i < lastIndex[stack.peek()]){
                visited[stack.pop()] = false;
            }
            
            stack.push(ch - 'a');
            visited[ch - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            sb.append((char) (stack.pop() + 'a'));
        }
        
        return sb.reverse().toString();
    }
}